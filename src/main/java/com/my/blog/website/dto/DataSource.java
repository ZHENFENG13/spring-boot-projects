package com.my.blog.website.dto;

/**
 * 建立数据库连接的参数对象
 * Created by BlueT on 2017/3/4.
 */
public class DataSource {

    /**
     * 数据库url
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 数据库驱动名称
     */
    private String drivercClassName;

    /**
     * 数据库名字
     */
    private String dbName;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDrivercClassName() {
        return drivercClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDrivercClassName(String drivercClassName) {
        this.drivercClassName = drivercClassName;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", drivercClassName='" + drivercClassName + '\'' +
                ", dbName='" + dbName + '\'' +
                '}';
    }
}
