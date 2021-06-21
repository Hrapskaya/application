package fintech.test.application.controller;

import fintech.test.application.model.UserAccount;
import fintech.test.application.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.Map;

import static fintech.test.application.constant.Message.*;

@Controller
@RequestMapping("/user")
public class UserController {

    public static final int MAX_USER_NUMBER_ON_PAGE = 1;

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public String findUserPage(Model model,
                               @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = MAX_USER_NUMBER_ON_PAGE) Pageable pageable) {
//        log.info("Handling find user page number: " + page + " request");
        Page<UserAccount> userAccountPage = userAccountService.findPage(pageable);
        model.addAttribute("userPage", userAccountPage);
        return "list";
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable Integer id,
                           Model model) {
//        log.info("Handling find user by id: " + id + " request");
        UserAccount userAccount = userAccountService.findById(id);
        if(userAccount == null){
            model.addAttribute("error", ERROR_PAGE_NOT_FOUND);
        }else {
            model.addAttribute("userAccount", userAccount);
        }
        return "view";
    }

    @GetMapping("/new")
    public String newUser() {
        return "newUser";
    }

    @PostMapping("/new")
    public String addUser(@Valid UserAccount userAccount,
                          BindingResult bindingResult,
                          Model model) {
//        log.info("Handling add user account: " + user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errors);
        } else {
            if (userAccount.getPassword().equals(userAccount.getRepeatPassword())) {
                UserAccount savedUserAccount = userAccountService.add(userAccount);
                if (savedUserAccount == null) {
                    model.addAttribute("userNameError", ERROR_USER_NAME_ALREADY_EXIST);
                } else {
                    return "redirect:/user/" + userAccount.getId();
                }
            } else {
                model.addAttribute("passwordError", ERROR_PASSWORDS_MISMATCH);
            }
        }
        return "newUser";
    }

    @GetMapping("/{id}/lock")
    public String changeStatus(@PathVariable Integer id,
                               Model model){
        UserAccount userAccount = userAccountService.changeStatus(id);
        if(userAccount == null){
            model.addAttribute("error", ERROR_USER_NOT_FOUND);
        }else {
            model.addAttribute("userAccount", userAccount);
        }
        return "view";
    }
}
