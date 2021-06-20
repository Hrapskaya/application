package fintech.test.application.controller;

import fintech.test.application.dto.User;
import fintech.test.application.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.Map;

import static fintech.test.application.constant.Message.ERROR_PASSWORDS_MISMATCH;
import static fintech.test.application.constant.Message.ERROR_USER_NAME_ALREADY_EXIST;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/{page}")
    public String findUserPage(@PathVariable Integer page) {
//        log.info("Handling find user page number: " + page + " request");
        return "list";
    }

    @GetMapping("/new")
    public String newUser() {
        return "newUser";
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable Integer id) {
//        log.info("Handling find user by id: " + id + " request");
        User user = userService.findById(id);
        return "view";
    }

    @PostMapping("/new")
    public String addUser(@Valid User user,
                          BindingResult bindingResult,
                          Model model) {
//        log.info("Handling add user account: " + user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errors);
        } else {
            if (user.getPassword().equals(user.getRepeatPassword())) {
                if (userService.add(user)) {
                    return "home";
                } else {
                    model.addAttribute("userNameError", ERROR_USER_NAME_ALREADY_EXIST);
                }
            } else {
                model.addAttribute("passwordError", ERROR_PASSWORDS_MISMATCH);
            }
        }
        return "newUser";

    }
}
