package cn.lanqiao.springboot3;

import cn.lanqiao.springboot3.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootTestDemo2 {
    @Autowired
    private HelloService helloService;

    @Test
    public void sayHelloTest() {
        System.out.println(helloService.sayHello("程序员十三"));
    }
}
