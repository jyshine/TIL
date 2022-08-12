package com.example.secondservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondServiceController {
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome to the second service";
    }
}
