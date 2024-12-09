package org.example.controller;

import lombok.NoArgsConstructor;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/signup")
@RestController
@NoArgsConstructor(force = true)
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
