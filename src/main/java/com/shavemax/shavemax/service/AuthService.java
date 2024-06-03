package com.shavemax.shavemax.service;

import com.shavemax.shavemax.dto.CleanUserDTO;
import com.shavemax.shavemax.dto.SignInDTO;
import com.shavemax.shavemax.dto.SignUpDTO;
import com.shavemax.shavemax.entity.User;

import java.util.List;
import java.util.UUID;

public interface AuthService {
    List<User> findAll();
    String signIn(SignInDTO signInDTO);
    CleanUserDTO signUp(SignUpDTO signUpDTO);
//    ResponseEntity<String> verifyEmail(UUID id);
//    Token forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
//    Token changeEmail(ChangeEmailDTO changeEmailDTO);
//    ResponseEntity<String> verifyChangeEmail(VerificationChangeEmailDTO verificationChangeEmailDTO);
//    ResponseEntity<String> verifyForgotPassword(VerificationForgotPasswordDTO verificationForgotPasswordDTO);
//    ResponseEntity<String> resendEmail(ResendEmailDTO resendEmailDTO);
//    List<User> starter();
}
