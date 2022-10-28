package com.example.springcloudsleuthzipkinclient;

import com.example.springcloudsleuthzipkinclient.entity.Customer;
import com.example.springcloudsleuthzipkinclient.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringcloudSleuthZipkinClientApplication{


    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSleuthZipkinClientApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
