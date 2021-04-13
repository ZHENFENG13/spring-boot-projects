package com.site.springboot.core.service;

import com.site.springboot.core.entity.News;
import com.site.springboot.core.util.PageQueryUtil;
import com.site.springboot.core.util.PageResult;

public interface NewsService {
    String saveNews(News news);

    PageResult getNewsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 根据id获取详情
     *
     * @param newsId
     * @return
     */
    News queryNewsById(Long newsId);

    /**
     * 后台修改
     *
     * @param news
     * @return
     */
    String updateNews(News news);
}
