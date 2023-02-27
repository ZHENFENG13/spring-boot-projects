package cn.lanqiao.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot 单元测试");
        SpringApplication.run(Application.class, args);
    }
}