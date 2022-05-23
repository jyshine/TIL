package com.elk.elkspring.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {

    @RequestMapping(value = "/")
    public String successTest(){
        log.info("성공");

        return "ok";
    }

    @RequestMapping(value = "/fail")
    public String failTest(){
        log.error("Error");
        return "fail";
    }
}
