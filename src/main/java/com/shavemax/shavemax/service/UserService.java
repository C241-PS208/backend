package com.shavemax.shavemax.service;

import com.shavemax.shavemax.dto.CleanUserDTO;
import com.shavemax.shavemax.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void deleteUser(User user);

    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    CleanUserDTO getCleanUserById(Long id);
    CleanUserDTO getCleanUserByEmail(String email);

    User getUserFromJWT(String jwt);
}
