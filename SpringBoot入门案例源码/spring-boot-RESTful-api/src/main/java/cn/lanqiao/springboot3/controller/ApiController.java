package cn.lanqiao.springboot3.controller;

import cn.lanqiao.springboot3.common.Result;
import cn.lanqiao.springboot3.common.ResultGenerator;
import cn.lanqiao.springboot3.dao.UserDao;
import cn.lanqiao.springboot3.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 13
 * @qq交流群 784785001
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Resource
    UserDao userDao;

    // 查询一条记录
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<User> getOne(@PathVariable("id") Integer id) {
        if (id == null || id < 1) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        User user = userDao.getUserById(id);
        if (user == null) {
            return ResultGenerator.genFailResult("无此数据");
        }
        return ResultGenerator.genSuccessResult(user);
    }

    // 查询所有记录
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<User>> queryAll() {
        List<User> users = userDao.findAllUsers();
        return ResultGenerator.genSuccessResult(users);
    }

    // 新增一条记录
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> insert(@RequestBody User user) {
        // 参数验证
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        return ResultGenerator.genSuccessResult(userDao.insertUser(user) > 0);
    }

    // 修改一条记录
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> update(@RequestBody User tempUser) {
        //参数验证
        if (tempUser.getId() == null || tempUser.getId() < 1 || StringUtils.isEmpty(tempUser.getName()) || StringUtils.isEmpty(tempUser.getPassword())) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        //实体验证，不存在则不继续修改操作
        User user = userDao.getUserById(tempUser.getId());
        if (user == null) {
            return ResultGenerator.genFailResult("参数异常");
        }
        user.setName(tempUser.getName());
        user.setPassword(tempUser.getPassword());
        return ResultGenerator.genSuccessResult(userDao.updUser(user) > 0);
    }

    // 删除一条记录
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> delete(@PathVariable("id") Integer id) {
        if (id == null || id < 1) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        return ResultGenerator.genSuccessResult(userDao.delUser(id) > 0);
    }

}
