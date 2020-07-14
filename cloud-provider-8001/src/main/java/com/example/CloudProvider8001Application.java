package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class CloudProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider8001Application.class, args);
    }

}
