package com.example.springcloudsleuthzipkinclient.controlelr;

import java.lang.reflect.ParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Home {

    RestTemplate restTemplate;

    @Autowired
    public Home(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/zipkin")
    public String home(){
        String format = String.format("http://127.0.0.1:5001/test");
        ResponseEntity<String> exchange = restTemplate.exchange(format, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });

        System.out.println(exchange.getStatusCode());
        System.out.println(exchange.getBody());
        return "Hello zipkin!";
    }
}
