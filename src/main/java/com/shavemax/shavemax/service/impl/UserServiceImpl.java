package com.shavemax.shavemax.service.impl;

import com.shavemax.shavemax.config.AuthConfigProperties;
import com.shavemax.shavemax.dto.CleanUserDTO;
import com.shavemax.shavemax.entity.User;
import com.shavemax.shavemax.exception.UserNotFoundException;
import com.shavemax.shavemax.repository.UserRepository;
import com.shavemax.shavemax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shavemax.shavemax.utils.JWTUtility;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthConfigProperties authConfigProperties;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthConfigProperties authConfigProperties) {
        this.userRepository = userRepository;
        this.authConfigProperties = authConfigProperties;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public CleanUserDTO getCleanUserById(Long id) {
        User user = getUserById(id);
        if (user == null) {
            throw new EntityNotFoundException();
        }

        CleanUserDTO cleanUserDTO = new CleanUserDTO();
        cleanUserDTO.setEmail(user.getEmail());
        cleanUserDTO.setName(user.getName());
        cleanUserDTO.setRole(user.getRole());
        cleanUserDTO.setGender(user.getGender());
        return cleanUserDTO;
    }


    @Override
    public CleanUserDTO getCleanUserByEmail(String email) {
        User user = getUserByEmail(email);
        if (user == null) {
            throw new EntityNotFoundException();
        }

        CleanUserDTO cleanUserDTO = new CleanUserDTO();
        cleanUserDTO.setEmail(user.getEmail());
        cleanUserDTO.setName(user.getName());
        cleanUserDTO.setRole(user.getRole());
        cleanUserDTO.setGender(user.getGender());
        return cleanUserDTO;
    }

    @Override
    public User getUserFromJWT(String jwt) {
        Long userId = JWTUtility.extractUserId(jwt, authConfigProperties.getSecret());

        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
