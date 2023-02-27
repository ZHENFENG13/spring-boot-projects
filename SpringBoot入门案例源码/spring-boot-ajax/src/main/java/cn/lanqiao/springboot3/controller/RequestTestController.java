package cn.lanqiao.springboot3.controller;

import cn.lanqiao.springboot3.entity.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestTestController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(String info) {
        if (StringUtils.isEmpty(info)) {
            return "请输入info的值！";
        }
        return "你输入的内容是:" + info;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public List<User> test2() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("十一");
        user1.setPassword("12121");
        User user2 = new User();
        user2.setId(2);
        user2.setName("十二");
        user2.setPassword("21212");
        User user3 = new User();
        user3.setId(3);
        user3.setName("十三");
        user3.setPassword("31313");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

}
