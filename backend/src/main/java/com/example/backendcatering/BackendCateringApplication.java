package com.example.backendcatering;

import com.example.backendcatering.configuration.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class BackendCateringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendCateringApplication.class, args);
    }

}
