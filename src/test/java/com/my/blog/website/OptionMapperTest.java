package com.my.blog.website;

import com.my.blog.website.dao.OptionVoMapper;
import com.my.blog.website.modal.Vo.OptionVo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BlueT on 2017/3/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.my.blog.website.dao")
public class OptionMapperTest {
    @Autowired
    private OptionVoMapper optionMapper;

    @Test
    @Ignore
    @Rollback
    public void index(){
        List<OptionVo> list = new ArrayList<>();
        OptionVo op1 = new OptionVo();
        op1.setName("wq");
        op1.setValue("12");
        op1.setDescription("hahahha");
        list.add(op1);
        op1 = new OptionVo();
        op1.setName("scc");
        op1.setValue("22");
        op1.setDescription("woowow");
        list.add(op1);
        int i = optionMapper.insertOptions(list);
        Assert.assertEquals(list.size(),i);

//        op1 = new OptionVo();
//        op1.setName("lyf");
//
//        op1.setValue("33");
//        op1.setDescription("0009");
//        optionMapper.insertSelective(op1);
//
//
//        System.out.println(optionMapper.selectByExample(new OptionVoExample()));
    }
}
