package com.lou.springboot.dao;

import com.lou.springboot.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author 13
 * MyBatis 测试
 */
public interface UserDao {
    /**
     * 返回数据列表
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     * 添加
     *
     * @param User
     * @return
     */
    int insertUser(User User);

    /**
     * 修改
     *
     * @param User
     * @return
     */
    int updUser(User User);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delUser(Integer id);
}
