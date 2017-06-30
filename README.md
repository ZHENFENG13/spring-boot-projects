# My Blog

fork from [Tale](https://github.com/otale/tale)

**感觉这个博客总体上还是挺干净的，因此进行了二次开发，改为SpringBoot项目，修复Bug，修改相关功能，作为开源的Java博客模板。**<br/>

[Docker+SpringBoot+Mybatis+thymeleaf的Java博客系统开源啦](http://www.cnblogs.com/han-1034683568/p/6840493.html)

[My-Blog搭建过程：如何让一个网站从零到可以上线访问](http://www.cnblogs.com/han-1034683568/p/6885545.html)

[利用Dockerfile构建mysql镜像并实现数据的初始化及权限设置](http://www.cnblogs.com/han-1034683568/p/6941337.html)

# Quick Start

[1.如何部署My Blog](https://github.com/ZHENFENG13/My-Blog/wiki/1-%E5%A6%82%E4%BD%95%E9%83%A8%E7%BD%B2My-Blog)<br/>
 - [1.0 基础环境搭建](https://github.com/ZHENFENG13/My-Blog/wiki/1.0-%E5%9F%BA%E7%A1%80%E7%8E%AF%E5%A2%83)<br/>
 - [1.1 安装Docker环境](https://github.com/ZHENFENG13/My-Blog/wiki/1.1-安装Docker环境)<br/>
 - [1.2 安装docker-compose](https://github.com/ZHENFENG13/My-Blog/wiki/1.2-%E5%AE%89%E8%A3%85docker-compose)<br/>

[2.通过共享镜像直接部署My Blog](https://github.com/ZHENFENG13/My-Blog/wiki/2-%E9%80%9A%E8%BF%87%E5%85%B1%E4%BA%AB%E9%95%9C%E5%83%8F%E7%9B%B4%E6%8E%A5%E9%83%A8%E7%BD%B2My-Blog)<br/>

[3.1 非docker环境运行My Blog](https://github.com/ZHENFENG13/My-Blog/wiki/3.1-%E9%9D%9Edocker%E7%8E%AF%E5%A2%83%E8%BF%90%E8%A1%8CMy-Blog)<br/>

[3.2 将My Blog部署到tomcat(非docker环境)](https://github.com/ZHENFENG13/My-Blog/wiki/3.2-%E5%B0%86My-Blog%E9%83%A8%E7%BD%B2%E5%88%B0tomcat(%E9%9D%9Edocker%E7%8E%AF%E5%A2%83))<br/>

[4.开发环境运行代码](https://github.com/ZHENFENG13/My-Blog/wiki/4-%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83%E8%BF%90%E8%A1%8C%E4%BB%A3%E7%A0%81)

[5.博客上线及备案相关流程](https://github.com/ZHENFENG13/My-Blog/wiki/%E4%B8%8A%E7%BA%BF%E5%8F%8A%E5%A4%87%E6%A1%88%E7%9B%B8%E5%85%B3)

[**常见问题**](https://github.com/ZHENFENG13/My-Blog/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98)

# Preview

**首页：**
![首页](http://images2015.cnblogs.com/blog/859549/201705/859549-20170511122850691-373579903.png)
**文章详情页：**
![文章页](http://images2015.cnblogs.com/blog/859549/201705/859549-20170510225208988-1419050749.png)
**登录页：**
![登录页](http://images2015.cnblogs.com/blog/859549/201705/859549-20170511122916004-738411708.png)
**文章列表页：**
![文章列表页](http://images2015.cnblogs.com/blog/859549/201705/859549-20170510225259722-688622603.png)
**文章编辑页：**
![文章编辑页](http://images2015.cnblogs.com/blog/859549/201705/859549-20170510225330566-559394265.png)
**分类编辑：**
![分类编辑](http://images2015.cnblogs.com/blog/859549/201705/859549-20170510225357207-57945087.png)

# Log

2017-03-27 添加docker整合<br/>
2017-03-28 schema.sql修改<br/>
2017-03-28 install步骤，数据库地址配置时:mysql地址写为mysql容器的名字即可,即mysql:3306<br/>
2017-03-29 修复添加评论时空指针异常的bug<br/>
2017-03-30 添加预览功能,限制文章浏览，如果为草稿状态前端即使通过正确的url也不能浏览<br/>
2017-03-31 文章浏览数不变的bug,后期浏览数及评论这些参数放到缓存里去<br/>
2017-04-01 添加druid数据源<br/>
2017-04-02 重写mysql的Dockerfile文件，修改install过程<br/>
2017-04-15 bug修复,footer样式调整<br/>
2017-04-17 logo文件修改,附件上传功能<br/>
2017-04-18 评论功能及页面修改<br/>
2017-04-20 域名及网站的公网备案<br/>
2017-04-25 docker-compose实现多容器部署<br/>
2017-05-09 删除原install过程,改为脚本自动部署及初始化<br/>
2017-05-10 docker容器时区不同步问题修复,文件整理<br/>
2017-05-11 文件整理,排版和文案修改<br/>
2017-05-13 正式上线啦<br/>
2017-05-15 部署文档<br/>
2017-05-21 My-Blog上线过程记录<br/>
