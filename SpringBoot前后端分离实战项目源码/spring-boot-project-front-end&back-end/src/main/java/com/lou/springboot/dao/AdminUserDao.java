package com.lou.springboot.dao;

import com.lou.springboot.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http:13blog.site
 */
public interface AdminUserDao {

    /**
     * 根据参数查询用户列表
     *
     * @param param
     * @return
     */
    List<AdminUser> findAdminUsers(Map param);

    /**
     * 查询用户总数
     *
     * @param param
     * @return
     */
    int getTotalAdminUser(Map param);

    /**
     * 根据登录名和密码获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByUserNameAndPassword(@Param("userName") String userName, @Param("passwordMD5") String passwordMD5);

    /**
     * 根据userToken获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByToken(String userToken);

    /**
     * 根据id获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserById(Long id);

    /**
     * 根据用户名获取用户记录
     *
     * @return
     */
    AdminUser getAdminUserByUserName(String userName);

    /**
     * 新增用户记录
     *
     * @return
     */
    int addUser(AdminUser user);

    /**
     * 批量新增用户记录
     *
     * @return
     */
    int insertUsersBatch(@Param("adminUsers") List<AdminUser> adminUsers);

    /**
     * 修改密码
     *
     * @return
     */
    int updateUserPassword(@Param("userId") Long userId, @Param("newPassword") String newPassword);

    /**
     * 更新用户token值
     *
     * @param userId
     * @param newToken
     * @return
     */
    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(Object[] ids);

    /**
     * 查询所有用户列表
     *
     * @return
     */
    List<AdminUser> getAllAdminUsers();
}
