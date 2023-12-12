package com.example.demo.exception;

public class NotFoundException extends BaseException{
    public NotFoundException(String systemMessage, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace, String userMessage) {
        super(systemMessage, cause, enableSuppression, writableStackTrace, userMessage);
    }
    public NotFoundException(String systemMessage) {
        super(systemMessage);
    }
}
