package cn.lanqiao.springboot3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello ! spring-boot-projects";
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String hello2(String name) {
        return "hello ! " + name;
    }
}
