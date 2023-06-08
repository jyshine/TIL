package com.example.springservicelayereventsourcing.controller;

import com.example.springservicelayereventsourcing.entity.Users;
import com.example.springservicelayereventsourcing.service.UserService;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String createUser(){
        Users user = new Users();
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setUserName("june");
        user.setEmail("jyshine3@gmail.com");
        user.setNickName("jy");
        userService.createUser(user);
        return "ok";
    }
}
