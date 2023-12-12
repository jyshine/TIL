package com.example.demo.controller;

import com.example.demo.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {

    @Autowired
    ExceptionService exceptionService;

    @GetMapping("/")
    public String home() {
        return "test";
    }

    @GetMapping("/notfound")
    public String notfound()  {
        exceptionService.notFoundException(true);
        return "test";
    }

    @GetMapping("/exception")
    public String exception() throws Exception {
        exceptionService.exceptionTest(true);
        return "test";
    }
}
