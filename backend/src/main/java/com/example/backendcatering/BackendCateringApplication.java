package com.example.backendcatering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class BackendCateringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendCateringApplication.class, args);
        System.out.println(Sort.Direction.ASC);
    }

}
