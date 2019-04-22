package com.lou.springboot.controller;

import com.lou.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/addStringToRedis")
    @ResponseBody
    public Boolean addStringToRedis(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return true;
    }

    @GetMapping("/getStringFromRedis")
    @ResponseBody
    public String getStringFromRedis(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @GetMapping("/addUserToRedis")
    @ResponseBody
    public Boolean addUserToRedis(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        redisTemplate.opsForValue().set(name, user);
        return true;
    }

    @GetMapping("/getUserFromRedis")
    @ResponseBody
    public User getUserFromRedis(String name) {
        return (User) redisTemplate.opsForValue().get(name);
    }

    @GetMapping("/deleteUserFromRedis")
    @ResponseBody
    public Boolean deleteUserFromRedis(String name) {
        return redisTemplate.delete(name);
    }
}
