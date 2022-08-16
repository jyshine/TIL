package com.example.userservice.controller;

import com.example.userservice.vo.Gretting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    private Environment env;

    @Autowired
    private Gretting gretting;
    public UserController(Environment env) {
        this.env = env;
    }

    @GetMapping("/health-check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
//        return env.getProperty("gretting.message");
        return gretting.getMessage();
    }

}
