package com.example.backendcatering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;

@Document(collection = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course implements Serializable {
    @Id
    private Long id;
    private String name;
    private String cousine;
    private String type;
    private Integer dailyNumber;
    private Double price;
    private Double grade;
    private String description;
    private List<String> ingridients;
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
