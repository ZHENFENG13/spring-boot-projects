package cn.lanqiao.springboot3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试模块接口")
@RestController
public class TestModuleController {

    @Operation(summary = "测试")
    @GetMapping("/test")
    public String test() {
        return "测试接口";
    }

}