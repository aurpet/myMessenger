package com.mymessenger.controllers;

import com.mymessenger.model.User;
import com.mymessenger.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Aurimas
 * @created 2023-04-03
 */

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-users")
    public Map<Long, String> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/new-user")
    public String saveUser(@RequestBody User user) {
        if (userService.userExist(user.getUserName())) {
            return "User name exist";
        } else {
            userService.save(user);
            return "User register successfully";
        }
    }
}
