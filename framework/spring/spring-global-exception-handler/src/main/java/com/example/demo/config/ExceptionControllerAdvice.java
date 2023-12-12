package com.example.demo.config;

import com.example.demo.exception.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler({com.example.demo.exception.NotFoundException.class})
    public String notFoundException(NotFoundException ex) {
        System.out.println("notfound");
        System.out.println(ex.toString());
        System.out.println(ex.toStringWithStackTrace());
        return ex.getMessage();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public String violationException(ConstraintViolationException ex) {
        System.out.println("violationException");
        return ex.getMessage();
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public String exceptionHandle(Exception ex) {
        System.out.println("exception");
        return ex.getMessage();
    }

}
