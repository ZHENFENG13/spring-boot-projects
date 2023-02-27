package cn.lanqiao.springboot3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringBootWebMvcConfigurer implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/files/**").addResourceLocations("file:D:\\upload\\");
        registry.addResourceHandler("/files/**").addResourceLocations("file:/home/project/upload/");
    }
}
