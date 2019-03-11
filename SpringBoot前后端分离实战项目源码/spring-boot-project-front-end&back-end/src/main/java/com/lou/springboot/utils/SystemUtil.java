package com.lou.springboot.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http:13blog.site
 */
public class SystemUtil {

    private SystemUtil(){}


    /**
     * 登录或注册成功后,生成保持用户登录状态会话token值
     * @param src:为用户最新一次登录时的now()+user.id+random(4)
     * @return
     */
    public static String genToken(String src){
        if (null == src || "".equals(src)){
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return null;
        }
    }

}
