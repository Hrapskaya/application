package fintech.test.application.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static fintech.test.application.constant.PathConstant.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return HOME_PAGE;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {


        if (ControllerUtil.isAuthentication()) {
            return HOME_PAGE;
        }
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return LOGIN_PAGE;
    }
}
