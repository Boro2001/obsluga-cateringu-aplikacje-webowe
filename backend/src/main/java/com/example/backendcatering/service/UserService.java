package com.example.backendcatering.service;

import com.example.backendcatering.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface UserService {
    User register(String firstName, String lastName, String username, String email) throws Exception;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws Exception;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws Exception;

    void deleteUser(String username) throws IOException;

    void resetPassword(String email) throws Exception;

    User updateProfileImage(String username, MultipartFile profileImage) throws Exception;
}
