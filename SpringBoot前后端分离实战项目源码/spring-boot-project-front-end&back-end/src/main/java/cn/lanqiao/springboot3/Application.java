package cn.lanqiao.springboot3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 13
 * @qq交流群 784785001
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@SpringBootApplication
@MapperScan("cn.lanqiao.springboot3.dao")
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot前后端分离实战项目");
        SpringApplication.run(Application.class, args);
    }
}