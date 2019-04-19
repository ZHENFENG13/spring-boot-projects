package com.site.springboot.core.dao;

import com.site.springboot.core.entity.NewsComment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface NewsCommentMapper {
    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    NewsComment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);

    List<NewsComment> findNewsCommentList(Map map);

    int getTotalNewsComments(Map map);

    int checkDone(Integer[] ids);

    int deleteBatch(Integer[] ids);
}