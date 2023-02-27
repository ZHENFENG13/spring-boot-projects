package cn.lanqiao.springboot3.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name) {
        return "hello ," + name;
    }
}
