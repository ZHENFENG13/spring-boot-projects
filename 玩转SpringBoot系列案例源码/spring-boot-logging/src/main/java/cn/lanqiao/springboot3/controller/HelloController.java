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
        return "hello ! this is springboot3 project";
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String hello2(String name) {
        return "hello ! " + name;
    }

    @GetMapping("/log")
    @ResponseBody
    public String log() {
        logger.info("这是一条 info 级别的日志");
        logger.error("这是一条 error 级别的日志");
        logger.debug("这是一条 debug 级别的日志");
        logger.warn("这是一条 warn 级别的日志");
        return "日志打印";
    }
}
