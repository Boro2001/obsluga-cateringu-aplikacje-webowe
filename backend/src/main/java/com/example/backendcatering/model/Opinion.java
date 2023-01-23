package com.example.backendcatering.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Random;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Opinion {
    @Id
    private Long id;
    private String description;
    private Double grade;
    private String courseName;
    private String userName;
    public Opinion(String description, Double grade, String courseName, String userName) {
        Random rand = new Random();
        this.id = rand.nextLong();
        this.description = description;
        this.grade = grade;
        this.courseName = courseName;
        this.userName = userName;
    }
}
