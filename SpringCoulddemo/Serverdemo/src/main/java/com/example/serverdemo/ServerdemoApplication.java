package com.example.serverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerdemoApplication.class, args);
    }
}
