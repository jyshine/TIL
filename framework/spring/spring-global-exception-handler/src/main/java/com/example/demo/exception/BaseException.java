package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class BaseException extends RuntimeException{
    private String userMessage;
    private String systemMessage;
    private String code;

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Constructor
    |-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    public BaseException() {
        super();
    }

    public BaseException(String systemMessage) {
        super(systemMessage);

        // Throwable의 message 는 BaseException에서는 systemMessage인 것으로 간주함.
        this.systemMessage = systemMessage;
    }
    public BaseException(String systemMessage, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(systemMessage, cause, enableSuppression, writableStackTrace);

        // Throwable의 message 는 BaseException에서는 systemMessage인 것으로 간주함.
        this.systemMessage = systemMessage;
    }

    public BaseException(String systemMessage, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                         String userMessage) {
        super(systemMessage, cause, enableSuppression, writableStackTrace);

        // Throwable의 message 는 BaseException에서는 systemMessage인 것으로 간주함.
        this.systemMessage = systemMessage;
        this.userMessage = userMessage;
    }

    public String toStringWithStackTrace() {
        return String.format("\n" +
                        "%s" +
                        " - userMessage: %s\n" +
                        " - systemMessage: %s\n" +
                        " - code: %s\n",
                ExceptionUtils.getStackTrace(this),
                userMessage, systemMessage, code );
    }
}
