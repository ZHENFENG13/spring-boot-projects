package com.site.springboot.core.dao;

import com.site.springboot.core.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AdminMapper {
    int deleteByPrimaryKey(Byte adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    Admin login(@Param("userName") String userName, @Param("password") String password);
}