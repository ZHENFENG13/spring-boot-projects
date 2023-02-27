package cn.lanqiao.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        servers = {
                @Server(url = "/", description = "Default Server URL")
        }
)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        System.out.println("Spring Boot整合Swagger");
        SpringApplication.run(Application.class, args);
    }
}