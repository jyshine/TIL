package com.example.springboot_graphql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(path = "/hello")
    public String hello(){
        return "hello world!";
    }
}
