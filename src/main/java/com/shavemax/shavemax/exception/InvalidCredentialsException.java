package com.shavemax.shavemax.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BaseServiceException {
    public static final String DEFAULT_MESSAGE = "Invalid email or password.";
    public static final String DEFAULT_TITLE = UserNotFoundException.class.getSimpleName();
    public static final int DEFAULT_HTTP_CODE = HttpStatus.NOT_FOUND.value();

    public InvalidCredentialsException() {
        super(DEFAULT_MESSAGE, DEFAULT_TITLE, DEFAULT_HTTP_CODE);
    };
}
