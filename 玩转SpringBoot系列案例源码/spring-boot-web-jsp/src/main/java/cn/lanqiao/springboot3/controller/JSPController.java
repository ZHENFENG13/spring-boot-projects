package cn.lanqiao.springboot3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("info", "Spring Boot 3.x 整合 JSP");
        return "hello";
    }

}
