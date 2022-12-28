package com.example.backendcatering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Document(collection = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cousine;
    private String type;
    private Integer dailyNumber;
    private Double price;
    private String description;
    @ElementCollection
    private List<String> ingridients;
    @ElementCollection
    private List<String> images;

    public Course(String name, String cousine, String type, Integer daily_number, Double price, String description, List<String> ingridients, List<String> images) {
        this.name = name;
        this.cousine = cousine;
        this.type = type;
        this.dailyNumber = daily_number;
        this.price = price;
        this.description = description;
        this.ingridients = ingridients;
        this.images = images;
    }
}
