package com.example.backendcatering.controller;

import com.example.backendcatering.model.ERole;
import com.example.backendcatering.model.Role;
import com.example.backendcatering.model.User;
import com.example.backendcatering.repository.RoleRepository;
import com.example.backendcatering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping ("/ban/{username}")
    public void banUser(@PathVariable String username){
        User user = userRepository.findByUsername(username).orElse(null);
        System.out.println("bannign user");
        userRepository.deleteById(user.getId());
        if(user!=null) {
            Set<Role> roles = new HashSet<>();
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    @PostMapping("/unban/{username}")
    public void unbanUser(@PathVariable String username){
        User user = userRepository.findByUsername(username).orElse(null);
        System.out.println("ubamnnig user");
        assert user != null;
        userRepository.deleteById(user.getId());
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

}
