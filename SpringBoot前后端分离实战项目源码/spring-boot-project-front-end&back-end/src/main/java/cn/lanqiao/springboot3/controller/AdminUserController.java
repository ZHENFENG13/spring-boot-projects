package cn.lanqiao.springboot3.controller;

import cn.lanqiao.springboot3.common.Constants;
import cn.lanqiao.springboot3.common.Result;
import cn.lanqiao.springboot3.common.ResultGenerator;
import cn.lanqiao.springboot3.config.annotation.TokenToUser;
import cn.lanqiao.springboot3.entity.AdminUser;
import cn.lanqiao.springboot3.service.AdminUserService;
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
@RequestMapping("/users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

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
        return ResultGenerator.genSuccessResult(adminUserService.getAdminUserPage(pageUtil));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody AdminUser user) {
        Result result = ResultGenerator.genFailResult("登录失败");
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            result.setMessage("请填写登录信息！");
        }
        AdminUser loginUser = adminUserService.updateTokenAndLogin(user.getUserName(), user.getPassword());
        if (loginUser != null) {
            result = ResultGenerator.genSuccessResult(loginUser);
        }
        return result;
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody AdminUser user, @TokenToUser AdminUser loginUser) {
        if (loginUser == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN, "未登录！");
        }
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }
        AdminUser tempUser = adminUserService.selectByUserName(user.getUserName());
        if (tempUser != null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "用户已存在勿重复添加！");
        }
        if ("admin".endsWith(user.getUserName().trim())) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "不能添加admin用户！");
        }
        if (adminUserService.save(user) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public Result update(@RequestBody AdminUser user, @TokenToUser AdminUser loginUser) {
        if (loginUser == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN, "未登录！");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "请输入密码！");
        }
        AdminUser tempUser = adminUserService.selectById(user.getId());
        if (tempUser == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "无此用户！");
        }
        if ("admin".endsWith(tempUser.getUserName().trim())) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "不能修改admin用户！");
        }
        tempUser.setPassword(user.getPassword());
        if (adminUserService.updatePassword(user) > 0) {
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
        if (adminUserService.deleteBatch(ids) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}