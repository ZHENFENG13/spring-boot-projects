package cn.lanqiao.springboot3.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DataSourceController {

    //自动配置，因此可以直接通过 @Autowired 注入进来
    @Autowired
    DataSource dataSource;

    // 查询数据源信息
    @GetMapping("/datasource")
    public Map<String, Object> datasource() throws SQLException {
        Map result = new HashMap();
        result.put("数据源类名", dataSource.getClass()+"");
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        // 判断连接对象是否为空
        result.put("能否正确获得连接", connection != null);
        connection.close();
        return result;
    }

    // 查询数据源信息
    @GetMapping("/datasource2")
    public Map<String, Object> datasource2() throws SQLException {
        DruidDataSource druidDataSource = (DruidDataSource)dataSource;
        Map result = new HashMap();
        result.put("数据源类名", druidDataSource.getClass()+"");
        // 获取数据库连接对象
        Connection connection = druidDataSource.getConnection();
        // 判断连接对象是否为空
        result.put("能否正确获得连接", connection != null);
        result.put("initialSize值为",druidDataSource.getInitialSize());
        result.put("maxActive值为",druidDataSource.getMaxActive());
        result.put("minIdle值为",druidDataSource.getMinIdle());
        result.put("validationQuery值为",druidDataSource.getValidationQuery());
        result.put("maxWait值为",druidDataSource.getMaxWait());
        connection.close();
        return result;
    }

}
