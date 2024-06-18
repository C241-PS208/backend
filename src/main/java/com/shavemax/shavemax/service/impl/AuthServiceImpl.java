package com.shavemax.shavemax.service.impl;

import com.shavemax.shavemax.config.AuthConfigProperties;
import com.shavemax.shavemax.dto.CleanUserDTO;
import com.shavemax.shavemax.dto.SignInDTO;
import com.shavemax.shavemax.dto.SignUpDTO;
import com.shavemax.shavemax.entity.Token;
import com.shavemax.shavemax.entity.User;
import com.shavemax.shavemax.enums.RoleEnum;
import com.shavemax.shavemax.enums.TokenType;
import com.shavemax.shavemax.exception.InvalidCredentialsException;
import com.shavemax.shavemax.exception.UserAlreadyExistsException;
import com.shavemax.shavemax.repository.RoleRepository;
import com.shavemax.shavemax.repository.TokenRepository;
import com.shavemax.shavemax.repository.UserRepository;
import com.shavemax.shavemax.service.AuthService;
import com.shavemax.shavemax.service.UserService;

import com.shavemax.shavemax.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final TokenRepository tokenRepository;
    private final AuthConfigProperties authConfigProperties;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, UserService userService, TokenRepository tokenRepository, AuthConfigProperties authConfigProperties, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.tokenRepository = tokenRepository;
        this.authConfigProperties = authConfigProperties;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @Override
    public String signIn(SignInDTO signInDTO) {
        User user = userService.getUserByEmail(signInDTO.getEmail());

        // checks if email or password is wrong
        if (user == null || !BCrypt.checkpw(signInDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return "Bearer " + JWTUtility.jwtGenerator(user.getId(), authConfigProperties.getSecret(), user.getRole().getName());

    }

    @Override
    public CleanUserDTO signUp(SignUpDTO signUpDTO) {
        User existingUser = userService.getUserByEmail(signUpDTO.getEmail());
        if (existingUser != null) {
            throw new UserAlreadyExistsException();
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signUpDTO.getName());
        user.setRole(roleRepository.findRoleByName(RoleEnum.USER));
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        user.setGender(signUpDTO.getGender());
        userService.saveUser(user);

        Token token = generateToken(user);

        CleanUserDTO cleanUserDTO = new CleanUserDTO();
        cleanUserDTO.setName(user.getName());
        cleanUserDTO.setRole(user.getRole());
        cleanUserDTO.setEmail(user.getEmail());
        cleanUserDTO.setGender(user.getGender());
        return cleanUserDTO;
    }

    private Token generateToken(User user) {
        Token token = new Token();
        token.setToken(UUID.randomUUID());
        token.setUser(user);
        token.setTokenType(TokenType.ACCOUNT_VERIFICATION);
        token.setIssuedAt(Instant.now());
        token.setExpiredAt(Instant.now().plus(1, ChronoUnit.MINUTES));
        return tokenRepository.save(token);
    }
}
