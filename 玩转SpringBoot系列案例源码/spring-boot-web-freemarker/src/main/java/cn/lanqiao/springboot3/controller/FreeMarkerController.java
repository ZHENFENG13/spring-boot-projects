package cn.lanqiao.springboot3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreeMarkerController {

    @GetMapping("/freemarker")
    public ModelAndView hello(@RequestParam(value = "info", required = false, defaultValue = "springboot3-freemarker") String info) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("info",info);
        modelAndView.setViewName("freemarker");
        return modelAndView;
    }
}
