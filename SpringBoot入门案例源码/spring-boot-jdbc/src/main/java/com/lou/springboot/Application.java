package com.lou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello shiyanlou!
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot 连接数据库以及在 Spring Boot 项目中操作数据库");
        SpringApplication.run(Application.class, args);
    }
}