package com.shavemax.shavemax.restcontroller;

import com.shavemax.shavemax.dto.SignInDTO;
import com.shavemax.shavemax.dto.SignUpDTO;
import com.shavemax.shavemax.entity.User;
import com.shavemax.shavemax.service.AuthService;
import com.shavemax.shavemax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthRestController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInDTO signInDTO) {
        String token = authService.signIn(signInDTO);
        User user = userService.getUserByEmail(signInDTO.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("gender", user.getGender());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO) {
        return ResponseEntity.ok(authService.signUp(signUpDTO));
    }
}
