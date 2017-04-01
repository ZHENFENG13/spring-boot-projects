package com.my.blog.website;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.modal.Vo.UserVo;
import com.my.blog.website.service.ISiteService;
import com.my.blog.website.service.IUserService;
import com.my.blog.website.dao.CommentVoMapper;
import com.my.blog.website.modal.Vo.CommentVo;
import com.my.blog.website.modal.Vo.ContentVo;
import com.my.blog.website.service.IContentService;
import com.my.blog.website.service.IOptionService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 003.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@MapperScan("com.my.blog.website.dao")
public class JDBCTest {
    @Autowired
    private IUserService userService;

    @Autowired
    private IOptionService optionService;

    @Autowired
    private CommentVoMapper commentMapper;

    @Autowired
    private ISiteService siteService;

    @Autowired
    private IContentService contentService;

    @Test
    @Ignore
    @Rollback
    public void testConnect() {
        UserVo user = new UserVo();
        user.setUsername("wangqiang");
        user.setPassword("123456");
        int i = userService.insertUser(user);

        optionService.insertOption("ssss", "qwqwq");
       Assert.assertEquals(1,i);
    }

    @Ignore
    @Test
    public void testPage(){
//        int pageSize = 8;
//        PageHelper.startPage(1, pageSize);
//        List<CommentVo> byPage = commentMapper.findByPage();
//        Assert.assertEquals(byPage.size(),pageSize);
    }

    @Test
    @Ignore
    public void testPageService(){
        int limit = 3;
        List<CommentVo> commentVos = siteService.recentComments(limit);
        Assert.assertEquals(commentVos.size(),limit);
    }

    @Test
    @Ignore
    public void testContentPage(){
        PageInfo<ContentVo> contents = contentService.getContents(1, 10);
        System.out.println(contents);
    }

}
