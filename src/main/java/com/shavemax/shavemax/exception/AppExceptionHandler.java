package com.shavemax.shavemax.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> userNotFound(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(userNotFoundException.generateCustomErrorResponse(), HttpStatus.valueOf(userNotFoundException.getHttpStatusCode()));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> userNotFound(InvalidCredentialsException invalidCredentialsException) {
        return new ResponseEntity<>(invalidCredentialsException.generateCustomErrorResponse(), HttpStatus.valueOf(invalidCredentialsException.getHttpStatusCode()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<CustomErrorResponse> userNotFound(UserAlreadyExistsException userAlreadyExistsException) {
        return new ResponseEntity<>(userAlreadyExistsException.generateCustomErrorResponse(), HttpStatus.valueOf(userAlreadyExistsException.getHttpStatusCode()));
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<CustomErrorResponse> userNotFound(ForbiddenException forbiddenException) {
        return new ResponseEntity<>(forbiddenException.generateCustomErrorResponse(), HttpStatus.valueOf(forbiddenException.getHttpStatusCode()));
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<CustomErrorResponse> userNotFound(JWTVerificationException jwtVerificationException) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), "Token expired", jwtVerificationException.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<CustomErrorResponse> userNotFound(TokenExpiredException tokenExpiredException) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), "Token expired", tokenExpiredException.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
}
