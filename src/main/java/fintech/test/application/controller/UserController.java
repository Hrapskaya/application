package fintech.test.application.controller;

import fintech.test.application.dto.User;
import fintech.test.application.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {

    private final UserService userService;

    @GetMapping("/{page}")
    public Page<User> findUserPage(@PathVariable Integer page){
        log.info("Handling find user page number: " + page + " request");
        return userService.findPage(page);
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Integer id){
        log.info("Handling find user by id: " + id + " request");
        User user = userService.findById(id);
        return user;
    }

    @GetMapping("/new")
    public String create(ModelMap model){
        return null;
    }

    @PostMapping("/new")
    public User createUser(@RequestBody User user){
        log.info("Handling save user account: " + user);
        return userService.save(user);
    }
}
