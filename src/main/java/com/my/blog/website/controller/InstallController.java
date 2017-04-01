package com.my.blog.website.controller;

import com.my.blog.website.constant.WebConst;
import com.my.blog.website.dto.DataSource;
import com.my.blog.website.dto.LogActions;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.listener.InitListener;
import com.my.blog.website.modal.Bo.RestResponseBo;
import com.my.blog.website.modal.Vo.UserVo;
import com.my.blog.website.service.ILogService;
import com.my.blog.website.service.IOptionService;
import com.my.blog.website.service.IUserService;
import com.my.blog.website.utils.TaleUtils;
import com.my.blog.website.modal.Bo.InstallBo;
import com.my.blog.website.modal.Vo.LogVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 如果使用@Transcatinal注解添加到index方法上会默认开启数据库连接，由于此时还没有数据库配置所以会报错
 * Created by BlueT on 2017/3/3.
 */
@Controller
public class InstallController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstallController.class);

    @Resource
    private IUserService userService;

    @Resource
    private ILogService logService;

    @Resource
    private IOptionService optionService;

    /**
     * 跳转安装页面
     *
     * @param map
     * @return view
     */
    @GetMapping(value = "/install")
    public String index(ModelMap map) {
        String path = InstallController.class.getResource("/").getPath();
        File file = new File(path + WebConst.INSTALL_FILE_CONF);
        if (file.exists()) {
            map.addAttribute("is_install", !"1".equals(WebConst.initConfig.get("is_install")));
        } else {
            map.addAttribute("is_install", false);
        }
        return "install";
    }

    /**
     * 测试数据库链接
     *
     * @return
     */
    @PostMapping(value = "/install/testCon")
    @ResponseBody
    public RestResponseBo testConnection(DataSource dataSourceVo) {
        String url = "jdbc:mysql://" + dataSourceVo.getUrl() + "/" + dataSourceVo.getDbName() + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //MYSQL驱动
            Connection con = DriverManager.getConnection(url, dataSourceVo.getUsername(), dataSourceVo.getPassword());
            ScriptRunner runner = new ScriptRunner(con);
            runner.setAutoCommit(false);
            runner.setStopOnError(true);
            InputStreamReader isr = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("sql/schema.sql"), "UTF-8");
            BufferedReader read = new BufferedReader(isr);
            runner.runScript(read);
            //生成配置文件
            TaleUtils.updateJDBCFile( dataSourceVo.getUrl(), dataSourceVo.getDbName(), dataSourceVo.getUsername(), dataSourceVo.getPassword());
        } catch (Exception e) {
            String msg = "数据库连接失败, 请检查数据库配置";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }


    @PostMapping(value = "/install")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo doInstall(InstallBo installBo) {

//        网站参数
        String admin_pwd = installBo.getAdminPwd();
        String admin_email = installBo.getAdminEmail();
        String admin_user = installBo.getAdminUser();
        String site_url = installBo.getSiteUrl();
        String site_title = installBo.getSiteTitle();

//        数据库参数
        String dataBaseUrl = installBo.getUrl();
        String dbName = installBo.getDbName();
        String username = installBo.getUsername();
        String password = installBo.getPassword();

        if (StringUtils.isBlank(site_title) ||
                StringUtils.isBlank(site_url) ||
                StringUtils.isBlank(admin_user) ||
                StringUtils.isBlank(admin_pwd)) {
            return RestResponseBo.fail("请确认网站信息输入完整");
        }

        if (StringUtils.isBlank(dataBaseUrl) ||
                StringUtils.isBlank(dbName) ||
                StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return RestResponseBo.fail("请确认数据库信息输入完整");
        }

        if (admin_pwd.length() < 6 || admin_pwd.length() > 14) {
            return RestResponseBo.fail("请输入6-14位密码");
        }

        if (StringUtils.isNotBlank(admin_email) && !TaleUtils.isEmail(admin_email)) {
            return RestResponseBo.fail("邮箱格式不正确");
        }

        File lock = new File( "install.lock");
        try {
            try {
                lock.createNewFile();

                //保存站点数据
                UserVo users = new UserVo();
                users.setUsername(admin_user);
                users.setPassword(admin_pwd);
                users.setEmail(admin_email);
                users.setScreenName(admin_user);
                users.setCreated(TaleUtils.getCurrentTime());
                Integer uid = userService.insertUser(users);
                if (uid == null) {
                    LOGGER.error("sav user data fail");
                    throw new TipException("初始化站点失败");
                }

                //保存操作日志
                LogVo logVo = new LogVo();
                logVo.setCreated(TaleUtils.getCurrentTime());
                logVo.setAction(LogActions.INIT_SITE.getAction());
                logVo.setAuthorId(uid);
                logService.insertLog(logVo);
            } catch (Exception e) {
                if (lock.exists()) {
                    lock.delete();
                }
                LOGGER.error("insert fail:{}", e.getMessage());
                throw new TipException("初始化站点失败");
            }

            if (site_url.endsWith("/")) {
                site_url = site_url.substring(0, site_url.length() - 1);
            }

//            更新参数配置
            optionService.insertOption("site_title", site_title);
            optionService.insertOption("site_url", site_url);
//            更新配置常量map
            optionService.getOptions().forEach((option) -> WebConst.initConfig.put(option.getName(), option.getValue()));
            WebConst.INSTALL = true;

            InitListener.dbIsOk = true;
        } catch (Exception e) {
            String msg = "安装失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }


}
