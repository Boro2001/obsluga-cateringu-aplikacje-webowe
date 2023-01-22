package com.example.backendcatering.repository;

import com.example.backendcatering.model.ERole;
import com.example.backendcatering.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
