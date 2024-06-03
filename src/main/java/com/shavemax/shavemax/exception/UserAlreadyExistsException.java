package com.shavemax.shavemax.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BaseServiceException{
    public static final String DEFAULT_MESSAGE = "User already exists.";
    public static final String DEFAULT_TITLE = UserAlreadyExistsException.class.getSimpleName();
    public static final int DEFAULT_HTTP_CODE = HttpStatus.BAD_REQUEST.value();

    public UserAlreadyExistsException() {
        super(DEFAULT_MESSAGE, DEFAULT_TITLE, DEFAULT_HTTP_CODE);
    };
}