package com.example.backendcatering.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document()
@Getter
@Setter
@NoArgsConstructor
public class Opinion {
    @Id
    private Long id;
    private String name;
    private Double grade;

}
