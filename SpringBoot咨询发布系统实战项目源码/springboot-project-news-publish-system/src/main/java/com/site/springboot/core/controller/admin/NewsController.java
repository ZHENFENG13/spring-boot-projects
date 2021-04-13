package com.site.springboot.core.controller.admin;

import com.site.springboot.core.entity.News;
import com.site.springboot.core.service.CategoryService;
import com.site.springboot.core.service.NewsService;
import com.site.springboot.core.util.PageQueryUtil;
import com.site.springboot.core.util.Result;
import com.site.springboot.core.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
@RequestMapping("/admin")
public class NewsController {

    @Resource
    private NewsService newsService;
    @Resource
    private CategoryService categoryService;

    @GetMapping("/news")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "news");
        return "admin/news";
    }

    @GetMapping("/news/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        request.setAttribute("categories", categoryService.getAllCategories());
        return "admin/edit";
    }

    @GetMapping("/news/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newsService.getNewsPage(pageUtil));
    }

    @PostMapping("/news/save")
    @ResponseBody
    public Result save(@RequestParam("newsTitle") String newsTitle,
                       @RequestParam("newsCategoryId") Long newsCategoryId,
                       @RequestParam("newsContent") String newsContent,
                       @RequestParam("newsCoverImage") String newsCoverImage,
                       @RequestParam("newsStatus") Byte newsStatus) {
        if (StringUtils.isEmpty(newsTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (newsTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (StringUtils.isEmpty(newsContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (newsContent.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(newsCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        News news = new News();
        news.setNewsCategoryId(newsCategoryId);
        news.setNewsContent(newsContent);
        news.setNewsCoverImage(newsCoverImage);
        news.setNewsStatus(newsStatus);
        news.setNewsTitle(newsTitle);
        String saveBlogResult = newsService.saveNews(news);
        if ("success".equals(saveBlogResult)) {
            return ResultGenerator.genSuccessResult("添加成功");
        } else {
            return ResultGenerator.genFailResult(saveBlogResult);
        }
    }

    @GetMapping("/news/edit/{newsId}")
    public String edit(HttpServletRequest request, @PathVariable("newsId") Long newsId) {
        request.setAttribute("path", "edit");
        News news = newsService.queryNewsById(newsId);
        if (news == null) {
            return "error/error_400";
        }
        request.setAttribute("news", news);
        request.setAttribute("categories", categoryService.getAllCategories());
        return "admin/edit";
    }

    @PostMapping("/news/update")
    @ResponseBody
    public Result update(@RequestParam("newsId") Long newsId,
                         @RequestParam("newsTitle") String newsTitle,
                         @RequestParam("newsCategoryId") Long newsCategoryId,
                         @RequestParam("newsContent") String newsContent,
                         @RequestParam("newsCoverImage") String newsCoverImage,
                         @RequestParam("newsStatus") Byte newsStatus) {
        if (StringUtils.isEmpty(newsTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (newsTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (StringUtils.isEmpty(newsContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (newsContent.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(newsCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        News news = new News();
        news.setNewsId(newsId);
        news.setNewsCategoryId(newsCategoryId);
        news.setNewsContent(newsContent);
        news.setNewsCoverImage(newsCoverImage);
        news.setNewsStatus(newsStatus);
        news.setNewsTitle(newsTitle);
        String updateResult = newsService.updateNews(news);
        if ("success".equals(updateResult)) {
            return ResultGenerator.genSuccessResult("修改成功");
        } else {
            return ResultGenerator.genFailResult(updateResult);
        }
    }

    @PostMapping("/news/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newsService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
