package cn.lanqiao.springboot3.service;


import cn.lanqiao.springboot3.utils.PageResult;
import cn.lanqiao.springboot3.utils.PageUtil;
import cn.lanqiao.springboot3.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @author 13
 * @qq交流群 784785001
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
public interface ArticleService {

    PageResult getArticlePage(PageUtil pageUtil);

    Article queryObject(Integer id);

    List<Article> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    int save(Article article);

    int update(Article article);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
