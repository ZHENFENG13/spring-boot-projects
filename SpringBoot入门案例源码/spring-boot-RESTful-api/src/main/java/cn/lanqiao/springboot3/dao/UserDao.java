package cn.lanqiao.springboot3.dao;

import cn.lanqiao.springboot3.entity.User;

import java.util.List;

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
     * 根据主键查询
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

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
