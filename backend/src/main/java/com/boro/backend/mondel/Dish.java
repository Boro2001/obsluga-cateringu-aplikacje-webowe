package com.boro.backend.mondel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Dish {
    private Long id;
    private String name;
    private String type;
    private String category;
    private int maxPerDay;
    private Float price;
    private String description;
}
