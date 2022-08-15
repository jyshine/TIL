package com.example.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {
    Environment environment;

    @Autowired
    public FirstServiceController(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "Welcome to The First Service";
    }

    @GetMapping("/message")
    public String message(
            @RequestHeader("first-request") String header){
        log.info(header);
        return "Hello world in first service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest httpServletRequest){
        log.info("Server port={}", httpServletRequest.getServerPort());
        return String.format("check first-service custom filter on Port : %s",
                environment.getProperty("local.server.port"));
    }
}
