package cn.lanqiao.springboot3.controller;

import cn.lanqiao.springboot3.service.TransactionTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;

@Controller
public class TransactionTestController {

    @Resource
    private TransactionTestService transactionTestService;

    // 事务管理测试
    @GetMapping("/transactionTest")
    @ResponseBody
    public String transactionTest() {

        // test1 未添加 @Transactional 注解
        transactionTestService.test1();

        // test2 添加了 @Transactional 注解
        transactionTestService.test2();

        return "请求完成";
    }

}
