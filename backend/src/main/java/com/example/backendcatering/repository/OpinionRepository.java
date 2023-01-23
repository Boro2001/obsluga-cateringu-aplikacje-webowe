package com.example.backendcatering.repository;

import com.example.backendcatering.model.Opinion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OpinionRepository extends MongoRepository<Opinion, Long> {
    public List<Opinion> getAllByCourseName(String courseName);
    public boolean existsByCourseNameAndUserName(String courseName, String userName);

}
