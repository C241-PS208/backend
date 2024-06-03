package com.shavemax.shavemax.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ForbiddenException extends BaseServiceException {
//    public ForbiddenException() {
//        super(HttpStatus.BAD_REQUEST, "Token not found in the request header.");
//    }

    public static final String DEFAULT_MESSAGE = "Token cannot be validated or role is not authorized.";
    public static final String DEFAULT_TITLE = ForbiddenException.class.getSimpleName();
    public static final int DEFAULT_HTTP_CODE = HttpStatus.FORBIDDEN.value();

    public ForbiddenException() {
        super(DEFAULT_MESSAGE, DEFAULT_TITLE, DEFAULT_HTTP_CODE);
    };
}