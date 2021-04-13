package com.site.springboot.core.dao;

import com.site.springboot.core.entity.News;
import com.site.springboot.core.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsMapper {
    int deleteByPrimaryKey(Long newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Long newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> findNewsList(PageQueryUtil pageUtil);

    int getTotalNews(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
}