//package com.example.springsecurity.password;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@SpringBootTest
//public class PasswordMatchingTest {
//    @Test
//    void withDefaultPasswordEncoderTest() {
//        // withDefaultPasswordEncoder Example
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("user")
//                .build();
//        System.out.println(user.getPassword());
//        // {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
//
//
//        // 유저가 여러명일 경우
//        // withDefaultPasswordEncoder Reusing the Builder
//        UserBuilder multipleUsers = User.withDefaultPasswordEncoder();
//        UserDetails userClient = multipleUsers
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        UserDetails admin = multipleUsers
//                .username("admin")
//                .password("password")
//                .roles("USER","ADMIN")
//                .build();
//    }
//}
