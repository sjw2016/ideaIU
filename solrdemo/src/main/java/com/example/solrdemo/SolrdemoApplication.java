package com.example.solrdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.example.solrdemo.dao","com.example.solrdemo.dao"})
@MapperScan(value = "mapper")
@EnableScheduling
public class SolrdemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(SolrdemoApplication.class, args);
    }

}