package com.mymessenger.controllers;

import com.mymessenger.dto.UserDto;
import com.mymessenger.model.User;
import com.mymessenger.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("userName") String userName) {
        if (userService.userExist(userName)) {
            return userService.deleteUser(userService.findUserByName(userName));
        } else {
            return "User doesn't exist";
        }
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/new")
    public String saveUser(@RequestBody User user) {
        if (userService.userExist(user.getUserName())) {
            return "User name exist";
        } else {
            userService.save(user);
            return "User register successfully";
        }
    }
}
