package com.example.backendcatering.repository;

import com.example.backendcatering.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, Long> {
    List<Course> findAll(Sort sort);
    List<Course> findAllByCousine(String cousine, Sort sort);
    List<Course> findAllByType(String type, Sort sort);
    List<Course> findAllByCousineAndType(String cousine, String type, Sort sort);
}
