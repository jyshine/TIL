package com.example.secondservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@Slf4j
public class SecondServiceController {
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome to the second service";
    }

    @GetMapping("/message")
    public String message(
            @RequestHeader("second-request") String header){
        log.info(header);
        return "Hello world in second service";
    }

    @GetMapping("/check")
    public String check(){
        return "check second-service custom filter";
    }
}
