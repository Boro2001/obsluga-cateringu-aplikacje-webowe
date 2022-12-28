package com.example.backendcatering.repository;

import com.example.backendcatering.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, Long> {

}
