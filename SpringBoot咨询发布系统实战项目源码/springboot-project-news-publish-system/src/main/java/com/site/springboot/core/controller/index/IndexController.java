package com.site.springboot.core.controller.index;

import cn.hutool.captcha.ShearCaptcha;
import com.site.springboot.core.entity.News;
import com.site.springboot.core.entity.NewsComment;
import com.site.springboot.core.service.CommentService;
import com.site.springboot.core.service.NewsService;
import com.site.springboot.core.util.AntiXssUtils;
import com.site.springboot.core.util.Result;
import com.site.springboot.core.util.ResultGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * @author 13
 * @qq交流群 784785001
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
public class IndexController {
    @Resource
    private CommentService commentService;
    @Resource
    private NewsService newsService;

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/news/{newsId}"})
    public String detail(HttpServletRequest request, @PathVariable("newsId") Long newsId) {
        News newsDetail = newsService.queryNewsById(newsId);
        if (newsDetail != null) {
            request.setAttribute("newsDetail", newsDetail);
            request.setAttribute("pageName", "详情");
            return "index/detail";
        } else {
            return "error/error_404";
        }

    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/news/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long newsId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String commentBody) {
        if (!StringUtils.hasText(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }

        ShearCaptcha shearCaptcha = (ShearCaptcha) session.getAttribute("verifyCode");
        if (shearCaptcha == null || !shearCaptcha.verify(verifyCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (!StringUtils.hasText(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == newsId || newsId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!StringUtils.hasText(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (!StringUtils.hasText(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        NewsComment comment = new NewsComment();
        comment.setNewsId(newsId);
        comment.setCommentator(AntiXssUtils.cleanString(commentator));
        comment.setCommentBody(AntiXssUtils.cleanString(commentBody));
        session.removeAttribute("verifyCode");//留言成功后删除session中的验证码信息
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }
}
