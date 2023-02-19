package com.easycar.backend.controller;

import com.easycar.backend.model.User;
import com.easycar.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User get(@RequestBody User user){
        return userService.register(user);
    }
}
