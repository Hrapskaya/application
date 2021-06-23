package fintech.test.application.controller;

import fintech.test.application.domain.UserAccount;
import fintech.test.application.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Map;

import static fintech.test.application.constant.MessageConstant.*;
import static fintech.test.application.constant.PathConstant.*;

@Controller
@RequestMapping("/user")
public class UserController {

    public static final int MAX_USER_NUMBER_ON_PAGE = 3;

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public String findUserPage(Model model,
                               @RequestParam(defaultValue = "") String filterUsername,
                               @RequestParam(defaultValue = "") String filterUserRole,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = MAX_USER_NUMBER_ON_PAGE) Pageable pageable) {

        Page<UserAccount> userAccountPage;
        if (filterUsername.isEmpty() && filterUserRole.isEmpty()) {
            userAccountPage = userAccountService.findPage(pageable);
        } else {
            userAccountPage = userAccountService.findPage(filterUsername, filterUserRole, pageable);
            model.addAttribute("filterUsername", filterUsername);
            model.addAttribute("filterUserRole", filterUserRole);
        }
        model.addAttribute("userPage", userAccountPage);
        return LIST_PAGE;
    }


    @GetMapping("/{id}")
    public String findUser(@PathVariable Integer id,
                           @RequestParam(required = false) String changeLock,
                           @AuthenticationPrincipal UserAccount user,
                           Model model) {
        UserAccount userAccount;
        if (changeLock != null && user.isAdmin()) {
            userAccount = userAccountService.changeStatus(id);
        } else {
            userAccount = userAccountService.findById(id);
        }
        if (userAccount == null) {
            model.addAttribute("error", ERROR_USER_NOT_FOUND);
        } else {
            model.addAttribute("userAccount", userAccount);
        }
        return VIEW_PAGE;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/new")
    public String newUser() {
        return NEW_USER_PAGE;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/new")
    public String addUser(String repeatPassword,
                          @Valid UserAccount userAccount,
                          BindingResult bindingResult,
                          Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errors);
        } else {
            if (userAccount.getPassword().equals(repeatPassword)) {
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
        return NEW_USER_PAGE;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id,
                       Model model) {
        UserAccount userAccount = userAccountService.findById(id);
        model.addAttribute("userAccount", userAccount);
        return EDIT_PAGE;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/edit")
    public String edit(@RequestParam(defaultValue = "") String password,
                       @RequestParam(defaultValue = "") String repeatPassword,
                       @Valid UserAccount userAccount,
                       BindingResult bindingResult,
                       Model model) {

        UserAccount updatedUserAccount = null;
        userAccount.setPassword(password);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);
            if (errors.size() == 1 && password.isEmpty()) {
                updatedUserAccount = userAccountService.update(userAccount);
            } else {
                model.mergeAttributes(errors);
            }
        } else {
            if (!password.isEmpty() && password.equals(repeatPassword)) {
                if (userAccountService.updatePassword(userAccount)) {
                    updatedUserAccount = userAccountService.update(userAccount);
                }
            } else {
                model.addAttribute("passwordError", ERROR_PASSWORDS_MISMATCH);
            }
        }
        if (updatedUserAccount == null) {
            model.addAttribute("error", ERROR_USER_NOT_FOUND);
            return EDIT_PAGE;
        } else {
            model.addAttribute("userAccount", updatedUserAccount);
            return EDIT_PAGE;
        }

    }
}