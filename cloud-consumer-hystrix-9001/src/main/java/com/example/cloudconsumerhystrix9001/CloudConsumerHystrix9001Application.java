package com.example.cloudconsumerhystrix9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class CloudConsumerHystrix9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrix9001Application.class, args);
    }

}
