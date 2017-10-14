package com.my.blog.website.service;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.modal.Vo.ContentVoExample;
import com.my.blog.website.modal.Vo.ContentVo;

/**
 * Created by Administrator on 2017/3/13 013.
 */
public interface IContentService {

//    /**
//     * 保存文章
//     * @param contentVo contentVo
//     */
//    void insertContent(ContentVo contentVo);

    /**
     * 发布文章
     * @param contents
     */
    String publish(ContentVo contents);

    /**
     *查询文章返回多条数据
     * @param p 当前页
     * @param limit 每页条数
     * @return ContentVo
     */
    PageInfo<ContentVo> getContents(Integer p, Integer limit);


    /**
     * 根据id或slug获取文章
     *
     * @param id id
     * @return ContentVo
     */
    ContentVo getContents(String id);

    /**
     * 根据主键更新
     * @param contentVo contentVo
     */
    void updateContentByCid(ContentVo contentVo);


    /**
     * 查询分类/标签下的文章归档
     * @param mid mid
     * @param page page
     * @param limit limit
     * @return ContentVo
     */
    PageInfo<ContentVo> getArticles(Integer mid, int page, int limit);

    /**
     * 搜索、分页
     * @param keyword keyword
     * @param page page
     * @param limit limit
     * @return ContentVo
     */
    PageInfo<ContentVo> getArticles(String keyword,Integer page,Integer limit);


    /**
     * @param commentVoExample
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ContentVo> getArticlesWithpage(ContentVoExample commentVoExample, Integer page, Integer limit);
    /**
     * 根据文章id删除
     * @param cid
     */
    String deleteByCid(Integer cid);

    /**
     * 编辑文章
     * @param contents
     */
    String updateArticle(ContentVo contents);


    /**
     * 更新原有文章的category
     * @param ordinal
     * @param newCatefory
     */
    void updateCategory(String ordinal,String newCatefory);
}
