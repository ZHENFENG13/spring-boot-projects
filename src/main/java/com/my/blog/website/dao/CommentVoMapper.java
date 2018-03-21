package com.my.blog.website.dao;

import com.my.blog.website.model.Vo.CommentVo;
import com.my.blog.website.model.Vo.CommentVoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CommentVoMapper {
    long countByExample(CommentVoExample example);

    int deleteByExample(CommentVoExample example);

    int deleteByPrimaryKey(Integer coid);

    int insert(CommentVo record);

    int insertSelective(CommentVo record);

    List<CommentVo> selectByExampleWithBLOBs(CommentVoExample example);

    List<CommentVo> selectByExample(CommentVoExample example);

    CommentVo selectByPrimaryKey(Integer coid);

    int updateByExampleSelective(@Param("record") CommentVo record, @Param("example") CommentVoExample example);

    int updateByExampleWithBLOBs(@Param("record") CommentVo record, @Param("example") CommentVoExample example);

    int updateByExample(@Param("record") CommentVo record, @Param("example") CommentVoExample example);

    int updateByPrimaryKeySelective(CommentVo record);

    int updateByPrimaryKeyWithBLOBs(CommentVo record);

    int updateByPrimaryKey(CommentVo record);
}