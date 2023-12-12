package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExceptionService {
    public void notFoundException(boolean isError)  {
        if (isError) {
            throw new com.example.demo.exception.NotFoundException("NotFoundException");
        }
    }

    public void exceptionTest(boolean isError) throws Exception {
        if (isError) {
            throw new Exception("Exception 발생");
        }
    }
}
