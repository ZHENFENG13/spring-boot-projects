package com.my.blog.website.listener;

import com.my.blog.website.constant.WebConst;
import com.my.blog.website.dao.OptionVoMapper;
import com.my.blog.website.service.ISiteService;
import com.my.blog.website.utils.Commons;
import com.my.blog.website.utils.TaleUtils;
import com.my.blog.website.modal.Vo.OptionVoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * 初始化监听器
 * Created by BlueT on 2017/3/3.
 */
public class InitListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitListener.class);

    public static boolean dbIsOk = false;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOGGER.debug("Enter method:init listener");
        DataSource newDataSource = TaleUtils.getNewDataSource();
        if (newDataSource != null) {
            dbIsOk = true;
        }
        if (dbIsOk) {
            try {
                ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
                OptionVoMapper optionDao = applicationContext.getBean(OptionVoMapper.class);

                // 初始化加载数据库配置
                optionDao.selectByExample(new OptionVoExample()).forEach((option) -> {
                    WebConst.initConfig.put(option.getName(), option.getValue());
                });
                WebConst.INSTALL = true;
                Commons.setSiteService(applicationContext.getBean(ISiteService.class));
            } catch (Exception e) {
                LOGGER.error("init dataSource fail:{}", e.getMessage());
            }
        }
        LOGGER.debug("Exit method:init listener");
    }


}
