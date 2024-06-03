package com.shavemax.shavemax.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseServiceException{
    public static final String DEFAULT_MESSAGE = "User is not found.";
    public static final String DEFAULT_TITLE = UserNotFoundException.class.getSimpleName();
    public static final int DEFAULT_HTTP_CODE = HttpStatus.NOT_FOUND.value();

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE, DEFAULT_TITLE, DEFAULT_HTTP_CODE);
    };
}