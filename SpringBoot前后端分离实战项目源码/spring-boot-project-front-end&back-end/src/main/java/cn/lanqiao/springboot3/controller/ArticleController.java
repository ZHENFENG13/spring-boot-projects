package cn.lanqiao.springboot3.controller;

import cn.lanqiao.springboot3.common.Constants;
import cn.lanqiao.springboot3.common.Result;
import cn.lanqiao.springboot3.common.ResultGenerator;
import cn.lanqiao.springboot3.config.annotation.TokenToUser;
import cn.lanqiao.springboot3.entity.AdminUser;
import cn.lanqiao.springboot3.entity.Article;
import cn.lanqiao.springboot3.service.ArticleService;
import cn.lanqiao.springboot3.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 13
 * @qq交流群 784785001
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }
        //查询列表数据
        PageUtil pageUtil = new PageUtil(params);
        return ResultGenerator.genSuccessResult(articleService.getArticlePage(pageUtil));
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public Result info(@PathVariable("id") Integer id) {
        Article article = articleService.queryObject(id);
        return ResultGenerator.genSuccessResult(article);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody Article article, @TokenToUser AdminUser loginUser) {
        if (article.getAddName()==null){
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "作者不能为空！");
        }
        if (loginUser == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN, "未登录！");
        }
        if (articleService.save(article) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Article article, @TokenToUser AdminUser loginUser) {
        if (loginUser == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN, "未登录！");
        }
        if (articleService.update(article) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@RequestBody Integer[] ids, @TokenToUser AdminUser loginUser) {
        if (loginUser == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN, "未登录！");
        }
        if (ids.length < 1) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }
        if (articleService.deleteBatch(ids) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
