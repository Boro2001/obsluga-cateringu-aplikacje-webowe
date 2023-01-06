package com.example.backendcatering.service;

import com.example.backendcatering.model.User;
import com.example.backendcatering.repository.UserRepository;
import com.example.backendcatering.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;

    @Override
    public User register(String firstName, String lastName, String username, String email) throws Exception {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws Exception {
        return null;
    }

    @Override
    public User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(String username) throws IOException {

    }

    @Override
    public void resetPassword(String email) throws Exception {

    }

    @Override
    public User updateProfileImage(String username, MultipartFile profileImage) throws Exception {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            LOGGER.error(username);
            throw new UsernameNotFoundException("'NO_USER_FOUND_BY_USERNAME'" + username);
        } else {
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            LOGGER.info("FOUND_USER_BY_USERNAME" + username);
            return userPrincipal;
        }
    }
}
