package cn.lanqiao.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 静态资源处理
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot 基础开发之静态资源处理案例");
        SpringApplication.run(Application.class, args);
    }
}