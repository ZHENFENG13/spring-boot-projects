# 需要做的工作列表

> 使用springboot和mybatis重构，加深对框架的理解，原本使用的是轻量级的mvc框架Blade。
> 模板引擎改用thymeleaf
> 实现docker服务部署mysql,tomcat,redis,mongdb并管理和Nginx反向代理
> 使用websocket推送
> 使用python或者webmagic爬虫，推荐每日好文。
> 切换数据源为druid,正式上线后使用其sql统计对项目进行优化
> 可能会删除install步骤,自己用的话没必要做这个操作

以上工作内容只是简单的罗列，详细内容后面补充。

# 工作记录

1. springBoot默认使用的是tomcat-jdbc的数据库连接池，默认使用的是dbcp的
2. 日志使用由'Starter POMs'，使用Commons Logging记录日志
3. 使用的是 [https://github.com/astarring/mybatis-generator-gui/releases]() 生成的DAO层
4. bug修复
5. 数据源切换
6. 结合docker，改写install过程，实现docker整合的优化
7. 为个人站上线做准备

# 存在的问题

1. 无法动态修改数据源的配置，只能重启解决（由于数据库连接参数变化造成的）
2. 错误描述直接使用的是中文，没有使用配置文件的方式，存在硬编码。
