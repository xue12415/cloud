package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudRabbitmq8070Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudRabbitmq8070Application.class, args);
    }

}
