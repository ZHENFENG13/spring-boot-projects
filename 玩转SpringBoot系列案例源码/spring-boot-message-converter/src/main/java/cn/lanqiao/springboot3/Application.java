package cn.lanqiao.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("消息转换器 HttpMessageConverter");
        SpringApplication.run(Application.class, args);
    }
}