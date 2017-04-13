package com.commy.exception;

/**
 * Created by xuht on 2017/4/13.
 */
public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
