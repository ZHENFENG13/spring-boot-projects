package cn.lanqiao.springboot3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lanqiao.springboot3.dao")
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        SpringApplication.run(Application.class, args);
    }
}