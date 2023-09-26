package com.example.springsecurity.password;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class EncoderTest {
    @Test
    void encoderTest() {
        // Create an encoder with strength 16
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("myPassword");
        assertTrue(encoder.matches("myPassword", result));
    }
}