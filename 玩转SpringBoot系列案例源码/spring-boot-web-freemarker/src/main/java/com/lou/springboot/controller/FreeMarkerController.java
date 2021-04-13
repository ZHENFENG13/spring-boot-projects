package com.lou.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FreeMarkerController {

    @GetMapping("/freemarker")
    public String hello(HttpServletRequest request, @RequestParam(value = "info", required = false, defaultValue = "springboot-freemarker") String info) {
        request.setAttribute("info", info);
        return "freemarker";
    }
}
