# Tale

fork from [Tale](https://github.com/otale/tale)

感觉这个博客总体上还是挺干净的,因此想改为springboot项目,修复bug,按照自己的想法改一下相关功能,然后作为自己的个人博客模板

2017-03-27 添加docker整合<br/>
2017-03-28 schema.sql修改<br/>
2017-03-28 install步骤，数据库地址配置时:mysql地址写为mysql容器的名字即可,即mysql:3306<br/>
2017-03-29 修复添加评论时空指针异常的bug<br/>
2017-03-30 添加预览功能,如果文章为草稿状态,前端即使通过正确的url也不能浏览<br/>
2017-03-31 文章浏览数不变的bug,后期浏览数及评论这些参数放到缓存里去<br/>
2017-04-01 druid
