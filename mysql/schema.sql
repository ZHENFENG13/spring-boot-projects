
-- 创建数据库
drop database if exists tale;
create database `tale` default character set utf8 collate utf8_general_ci;

use tale;

DROP TABLE IF EXISTS `t_logs`;

CREATE TABLE `t_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT ,
  `action` varchar(100) DEFAULT NULL ,
  `data` varchar(2000) DEFAULT NULL ,
  `author_id` int(10) DEFAULT NULL ,
  `ip` varchar(20) DEFAULT NULL ,
  `created` int(10) DEFAULT NULL ,
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
  `coid` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `cid` int(10) unsigned DEFAULT '0' ,
  `created` int(10) unsigned DEFAULT '0' ,
  `author` varchar(200) DEFAULT NULL ,
  `author_id` int(10) unsigned DEFAULT '0' ,
  `owner_id` int(10) unsigned DEFAULT '0' ,
  `mail` varchar(200) DEFAULT NULL ,
  `url` varchar(200) DEFAULT NULL ,
  `ip` varchar(64) DEFAULT NULL  ,
  `agent` varchar(200) DEFAULT NULL  ,
  `content` text ,
  `type` varchar(16) DEFAULT 'comment' ,
  `status` varchar(16) DEFAULT 'approved' ,
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`coid`),
  KEY `cid` (`cid`),
  KEY `created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_contents`;

CREATE TABLE `t_contents` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `title` varchar(200) DEFAULT NULL ,
  `slug` varchar(200) DEFAULT NULL ,
  `created` int(10) unsigned DEFAULT '0' ,
  `modified` int(10) unsigned DEFAULT '0' ,
  `content` text COMMENT '内容文字',
  `author_id` int(10) unsigned DEFAULT '0' ,
  `type` varchar(16) DEFAULT 'post'  ,
  `status` varchar(16) DEFAULT 'publish' ,
  `tags` varchar(200) DEFAULT NULL ,
  `categories` varchar(200) DEFAULT NULL ,
  `hits` int(10) unsigned DEFAULT '0' ,
  `comments_num` int(10) unsigned DEFAULT '0' ,
  `allow_comment` tinyint(1) DEFAULT '1' ,
  `allow_ping` tinyint(1) DEFAULT '1' ,
  `allow_feed` tinyint(1) DEFAULT '1' ,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `slug` (`slug`),
  KEY `created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_contents` WRITE;

INSERT INTO `t_contents` (`cid`, `title`, `slug`, `created`, `modified`, `content`, `author_id`, `type`, `status`, `tags`, `categories`, `hits`, `comments_num`, `allow_comment`, `allow_ping`, `allow_feed`)
VALUES
	(1,'about my blog','about',1487853610,1487872488,'### Hello World\r\n\r\nabout me\r\n\r\n### ...\r\n\r\n...',1,'page','publish',NULL,NULL,0,0,1,1,1),
	(2,'Hello My Blog',NULL,1487861184,1487872798,'## Hello  World.\r\n\r\n> ...\r\n\r\n----------\r\n\r\n\r\n<!--more-->\r\n\r\n```java\r\npublic static void main(String[] args){\r\n    System.out.println(\"Hello 13 Blog.\");\r\n}\r\n```',1,'post','publish','','default',10,0,1,1,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_metas`;

CREATE TABLE `t_metas` (
  `mid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `type` varchar(32) NOT NULL DEFAULT '' ,
  `description` varchar(200) DEFAULT NULL ,
  `sort` int(10) unsigned DEFAULT '0',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`mid`),
  KEY `slug` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_metas` WRITE;

INSERT INTO `t_metas` (`mid`, `name`, `slug`, `type`, `description`, `sort`, `parent`)
VALUES
	(1,'default',NULL,'category',NULL,0,0),
	(6,'my github','https://github.com/ZHENFENG13','link',NULL,0,0);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_options`;

CREATE TABLE `t_options` (
  `name` varchar(32) NOT NULL DEFAULT '',
  `value` varchar(1000) DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_options` WRITE;

INSERT INTO `t_options` (`name`, `value`, `description`)
VALUES
	('site_title','My Blog',''),
	('social_weibo','',NULL),
	('social_zhihu','',NULL),
	('social_github','',NULL),
	('social_twitter','',NULL),
	('allow_install','0',''),
	('site_theme','default',NULL),
	('site_keywords','13 Blog',NULL),
	('site_description','13 Blog',NULL);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_relationships`;

CREATE TABLE `t_relationships` (
  `cid` int(10) unsigned NOT NULL,
  `mid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cid`,`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_relationships` WRITE;

INSERT INTO `t_relationships` (`cid`, `mid`)
VALUES
	(2,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `home_url` varchar(200) DEFAULT NULL,
  `screen_name` varchar(32) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `activated` int(10) unsigned DEFAULT '0' ,
  `logged` int(10) unsigned DEFAULT '0',
  `group_name` varchar(16) DEFAULT 'visitor' ,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `name` (`username`),
  UNIQUE KEY `mail` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_users` (`uid`, `username`, `password`, `email`, `home_url`, `screen_name`, `created`, `activated`, `logged`, `group_name`)
VALUES
	(1, 'admin', 'a66abb5684c45962d887564f08346e8d', '1034683568@qq.com', NULL, 'admin', 1490756162, 0, 0, 'visitor');