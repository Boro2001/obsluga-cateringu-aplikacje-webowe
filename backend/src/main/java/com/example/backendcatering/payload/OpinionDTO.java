package com.example.backendcatering.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionDTO {
    private String description;
    private Double grade;
    private String courseName;
    private String userName;
}
