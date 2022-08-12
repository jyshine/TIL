package com.example.firstservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class FirstServiceController {

    @RequestMapping("welcome")
    public String welcome(){
        return "Welcome to The First Service";
    }

}
