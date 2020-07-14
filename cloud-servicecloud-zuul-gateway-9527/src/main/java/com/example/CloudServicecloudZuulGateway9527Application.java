package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.FeignClient;

@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
@FeignClient
@SpringBootApplication
public class CloudServicecloudZuulGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudServicecloudZuulGateway9527Application.class, args);
    }

}
