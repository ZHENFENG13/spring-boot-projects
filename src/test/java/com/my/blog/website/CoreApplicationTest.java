package com.my.blog.website;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTest
{
    private static final Logger logger = LoggerFactory.getLogger(CoreApplicationTest.class);
    @Value("${spring.datasource.url}")
    private String url;
    
    @Test
    @Ignore
    public void contextLoads()
    {
		logger.debug("Enter contextLoads method-----------------------------------------------------------------------wangqiang");

        Assert.assertEquals("jdbc:mysql://45.76.205.80:3306/tale", url);
    }
    
}
