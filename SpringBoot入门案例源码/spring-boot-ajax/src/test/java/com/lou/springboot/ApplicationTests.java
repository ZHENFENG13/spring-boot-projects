package com.lou.springboot;

import com.lou.springboot.controller.RequestTestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.apache.logging.log4j.util.Strings.EMPTY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private RequestTestController requestTestController;

    private static final String TEST_STRING = "abcdefg";
    private static final String NEED_INFO_ALERT_STRING = "请输入info的值！";

    @Test
    public void displayInfoTest() {
        final String expected = "你输入的内容是:" + TEST_STRING;
        final String test_data = requestTestController.test1(TEST_STRING);
        assertEquals(expected, test_data);
    }

    @Test
    public void displayInfoEmptyTest() {
        final String test_data = requestTestController.test1(EMPTY);
        assertEquals(NEED_INFO_ALERT_STRING, test_data);
    }

    @Test
    public void test2ApiTest() {
        assertNotNull(requestTestController.test2());
    }
}
