package com.example.cloudconsumerhystrix9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 访问方式：http://localhost:9001/hystrix
 */
@EnableHystrixDashboard
@SpringBootApplication
public class CloudConsumerHystrix9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrix9001Application.class, args);
    }

}
