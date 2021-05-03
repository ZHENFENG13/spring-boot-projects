package com.lou.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello shiyanlou!
 *
 */
@SpringBootApplication
@MapperScan("com.lou.springboot.dao")
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot 项目实践之 RESTful API 设计与实现");
        SpringApplication.run(Application.class, args);
    }
}