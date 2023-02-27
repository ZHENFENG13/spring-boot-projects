package cn.lanqiao.springboot3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lanqiao.springboot3.dao")
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot 整合 MyBatis 操作数据库");
        SpringApplication.run(Application.class, args);
    }
}