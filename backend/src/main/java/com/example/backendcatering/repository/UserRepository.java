package com.example.backendcatering.repository;

import com.example.backendcatering.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findUserByUsername(String username);
    User findUsersByIdAndActive(Long id);
    User findUserByEmail(String email);
}
