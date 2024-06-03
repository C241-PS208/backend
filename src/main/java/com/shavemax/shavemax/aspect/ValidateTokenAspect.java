package com.shavemax.shavemax.aspect;

import com.shavemax.shavemax.UserContext;
import com.shavemax.shavemax.config.AuthConfigProperties;
import com.shavemax.shavemax.entity.User;
import com.shavemax.shavemax.exception.ForbiddenException;
import com.shavemax.shavemax.exception.UserNotFoundException;
import com.shavemax.shavemax.service.UserService;
import com.shavemax.shavemax.utils.JWTUtility;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
@Configuration
public class ValidateTokenAspect {
    private final UserService userService;
    private final AuthConfigProperties authConfigProperties;

    @Autowired
    public ValidateTokenAspect(UserService userService, AuthConfigProperties authConfigProperties){
        this.userService = userService;
        this.authConfigProperties = authConfigProperties;
    }

    @Around("@annotation(com.shavemax.shavemax.aspect.ValidateToken)")
    public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = extractTokenFromHeader(request);

        if (token == null) {
            //TODO CHECK
            throw new ForbiddenException();
        }

        //TODO extract account id from token
        Long userId = JWTUtility.extractUserId(token, authConfigProperties.getSecret());

        ValidateToken validateTokenAnnotation = getValidateTokenAnnotation(joinPoint);

        // Check if the role is valid
        if (validateTokenAnnotation.value().length != 0 &&
                !JWTUtility.validateRole(token, authConfigProperties.getSecret(), validateTokenAnnotation.value())) {
            throw new ForbiddenException();
        }

        // Load account from the database
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }

        // Set the account in the context
        UserContext.setUser(user);

        // Continue with the method execution
        return joinPoint.proceed();
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        // Logic to extract token from the header
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // Remove "Bearer " prefix
        }

        return null;
    }

    private ValidateToken getValidateTokenAnnotation(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getAnnotation(ValidateToken.class);
    }
}
