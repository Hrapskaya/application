package fintech.test.application.controller;

import fintech.test.application.dto.UserAccountDto;
import fintech.test.application.service.UserAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {

    private final UserAccountService userAccountService;

    @GetMapping("/{page}")
    public Page<UserAccountDto> findUserPage(@PathVariable Integer page){
        log.info("Handling find user page number: " + page + " request");
        return userAccountService.findPage(page);
    }

    @GetMapping("/{id}")
    public UserAccountDto findUser(@PathVariable Integer id){
        log.info("Handling find user by id: " + id + " request");
        UserAccountDto userAccountDto = userAccountService.findById(id);
        return userAccountDto;
    }

    @PostMapping("/new")
    public UserAccountDto createUser(@RequestBody UserAccountDto userAccountDto){
        log.info("Handling save user account: " + userAccountDto);
        return userAccountService.save(userAccountDto);
    }
}
