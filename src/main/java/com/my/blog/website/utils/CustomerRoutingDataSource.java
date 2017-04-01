package com.my.blog.website.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现动态数据库
 * Created by Administrator on 2017/3/8 008.
 */
@Component
public class CustomerRoutingDataSource extends AbstractRoutingDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRoutingDataSource.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    @Override
    public void afterPropertiesSet() {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(null, dataSource);
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    /**
     * 动态修改数据源
     * 抛弃使用初始化时的默认数据源，而使用手动创建的
     *
     * @return 新的数据源
     */
    @Override
    protected DataSource determineTargetDataSource() {
        LOGGER.info("Enter CustomerRoutingDataSource determineTargetDataSource method:change dataSource");
        DataSource managerDataSource=TaleUtils.getNewDataSource();
        LOGGER.info("Exit CustomerRoutingDataSource determineTargetDataSource method.");
        return managerDataSource;
    }
}
