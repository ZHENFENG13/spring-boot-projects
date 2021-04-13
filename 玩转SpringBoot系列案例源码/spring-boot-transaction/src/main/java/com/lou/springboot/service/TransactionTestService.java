package com.lou.springboot.service;

import com.lou.springboot.dao.UserDao;
import com.lou.springboot.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionTestService {
    @Resource
    UserDao userDao;

    public Boolean test1() {
        User user = new User();
        user.setPassword("test1-password");
        user.setName("test1");
        // 在数据库表中新增一条记录
        userDao.insertUser(user);
        // 发生异常
        System.out.println(1 / 0);
        return true;
    }

    @Transactional
    public Boolean test2() {
        User user = new User();
        user.setPassword("test2-password");
        user.setName("test2");
        // 在数据库表中新增一条记录
        userDao.insertUser(user);
        // 发生异常
        System.out.println(1 / 0);
        return true;
    }
}
