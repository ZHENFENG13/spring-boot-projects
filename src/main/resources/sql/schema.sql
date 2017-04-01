
-- 创建数据库
-- create database `tale` default character set utf8 collate utf8_general_ci;

DROP TABLE IF EXISTS `t_logs`;

CREATE TABLE `t_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `action` varchar(100) DEFAULT NULL COMMENT '产生的动作',
  `data` varchar(2000) DEFAULT NULL COMMENT '产生的数据',
  `author_id` int(10) DEFAULT NULL COMMENT '发生人id',
  `ip` varchar(20) DEFAULT NULL COMMENT '日志产生的ip',
  `created` int(10) DEFAULT NULL COMMENT '日志创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_attach`;

CREATE TABLE `t_attach` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL DEFAULT '',
  `ftype` varchar(50) DEFAULT '',
  `fkey` varchar(100) NOT NULL DEFAULT '',
  `author_id` int(10) DEFAULT NULL,
  `created` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_comments`;

CREATE TABLE `t_comments` (
  `coid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'comment表主键',
  `cid` int(10) unsigned DEFAULT '0' COMMENT 'post表主键,关联字段',
  `created` int(10) unsigned DEFAULT '0' COMMENT '评论生成时的GMT unix时间戳',
  `author` varchar(200) DEFAULT NULL COMMENT '评论作者',
  `author_id` int(10) unsigned DEFAULT '0' COMMENT '评论所属用户id',
  `owner_id` int(10) unsigned DEFAULT '0' COMMENT '评论所属内容作者id',
  `mail` varchar(200) DEFAULT NULL COMMENT '评论者邮件',
  `url` varchar(200) DEFAULT NULL COMMENT '评论者网址',
  `ip` varchar(64) DEFAULT NULL COMMENT '评论者ip地址',
  `agent` varchar(200) DEFAULT NULL COMMENT '评论者客户端',
  `content` text COMMENT '评论内容',
  `type` varchar(16) DEFAULT 'comment' COMMENT '评论类型',
  `status` varchar(16) DEFAULT 'approved' COMMENT '评论状态',
  `parent` int(10) unsigned DEFAULT '0' COMMENT '父级评论',
  PRIMARY KEY (`coid`),
  KEY `cid` (`cid`),
  KEY `created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

DROP TABLE IF EXISTS `t_contents`;

CREATE TABLE `t_contents` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'post表主键',
  `title` varchar(200) DEFAULT NULL COMMENT '内容标题',
  `slug` varchar(200) DEFAULT NULL COMMENT '内容缩略名',
  `created` int(10) unsigned DEFAULT '0' COMMENT '内容生成时的GMT unix时间戳',
  `modified` int(10) unsigned DEFAULT '0' COMMENT '内容更改时的GMT unix时间戳',
  `content` text COMMENT '内容文字',
  `author_id` int(10) unsigned DEFAULT '0' COMMENT '内容所属用户id',
  `type` varchar(16) DEFAULT 'post' COMMENT '内容类别',
  `status` varchar(16) DEFAULT 'publish' COMMENT '内容状态',
  `tags` varchar(200) DEFAULT NULL COMMENT '标签列表',
  `categories` varchar(200) DEFAULT NULL COMMENT '分类列表',
  `hits` int(10) unsigned DEFAULT '0' COMMENT '点击次数',
  `comments_num` int(10) unsigned DEFAULT '0' COMMENT '内容所属评论数',
  `allow_comment` tinyint(1) DEFAULT '1' COMMENT '是否允许评论',
  `allow_ping` tinyint(1) DEFAULT '1' COMMENT '是否允许ping',
  `allow_feed` tinyint(1) DEFAULT '1' COMMENT '允许出现在聚合中',
  PRIMARY KEY (`cid`),
  UNIQUE KEY `slug` (`slug`),
  KEY `created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容表';

LOCK TABLES `t_contents` WRITE;

INSERT INTO `t_contents` (`cid`, `title`, `slug`, `created`, `modified`, `content`, `author_id`, `type`, `status`, `tags`, `categories`, `hits`, `comments_num`, `allow_comment`, `allow_ping`, `allow_feed`)
VALUES
	(1,'关于','about',1487853610,1487872488,'### Hello World\r\n\r\n这是我的关于页面\r\n\r\n### 当然还有其他\r\n\r\n具体你来写点什么吧',1,'page','publish',NULL,NULL,0,0,1,1,1),
	(2,'第一篇文章',NULL,1487861184,1487872798,'## Hello  World.\r\n\r\n> 第一篇文章总得写点儿什么?...\r\n\r\n----------\r\n\r\n\r\n<!--more-->\r\n\r\n```java\r\npublic static void main(String[] args){\r\n    System.out.println(\"Hello Tale.\");\r\n}\r\n```',1,'post','publish','','默认分类',10,0,1,1,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_metas`;

CREATE TABLE `t_metas` (
  `mid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目主键',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `slug` varchar(200) DEFAULT NULL COMMENT '项目缩略名',
  `type` varchar(32) NOT NULL DEFAULT '' COMMENT '项目类型',
  `description` varchar(200) DEFAULT NULL COMMENT '选项描述',
  `sort` int(10) unsigned DEFAULT '0' COMMENT '项目排序',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`mid`),
  KEY `slug` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目';

LOCK TABLES `t_metas` WRITE;

INSERT INTO `t_metas` (`mid`, `name`, `slug`, `type`, `description`, `sort`, `parent`)
VALUES
	(1,'默认分类',NULL,'category',NULL,0,0),
	(6,'王爵的技术博客','http://biezhi.me','link',NULL,0,0);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_options`;

CREATE TABLE `t_options` (
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '配置名称',
  `value` varchar(1000) DEFAULT '' COMMENT '配置值',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置表';

LOCK TABLES `t_options` WRITE;

INSERT INTO `t_options` (`name`, `value`, `description`)
VALUES
	('site_title','Tale博客系统',''),
	('social_weibo','',NULL),
	('social_zhihu','',NULL),
	('social_github','',NULL),
	('social_twitter','',NULL),
	('allow_install','0','是否允许重新安装博客'),
	('site_theme','default',NULL),
	('site_keywords','博客系统,Blade框架,Tale',NULL),
	('site_description','博客系统,Blade框架,Tale',NULL);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_relationships`;

CREATE TABLE `t_relationships` (
  `cid` int(10) unsigned NOT NULL COMMENT '内容主键',
  `mid` int(10) unsigned NOT NULL COMMENT '项目主键',
  PRIMARY KEY (`cid`,`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关联表';

LOCK TABLES `t_relationships` WRITE;

INSERT INTO `t_relationships` (`cid`, `mid`)
VALUES
	(2,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'user表主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `email` varchar(200) DEFAULT NULL COMMENT '用户的邮箱',
  `home_url` varchar(200) DEFAULT NULL COMMENT '用户的主页',
  `screen_name` varchar(32) DEFAULT NULL COMMENT '用户显示的名称',
  `created` int(10) unsigned DEFAULT '0' COMMENT '用户注册时的GMT unix时间戳',
  `activated` int(10) unsigned DEFAULT '0' COMMENT '最后活动时间',
  `logged` int(10) unsigned DEFAULT '0' COMMENT '上次登录最后活跃时间',
  `group_name` varchar(16) DEFAULT 'visitor' COMMENT '用户组',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `name` (`username`),
  UNIQUE KEY `mail` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
