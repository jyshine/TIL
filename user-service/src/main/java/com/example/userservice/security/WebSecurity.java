package com.example.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class WebSecurity {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web -> {
            web.ignoring().antMatchers("/users/**","/h2-console/**");

        });
    }
}
