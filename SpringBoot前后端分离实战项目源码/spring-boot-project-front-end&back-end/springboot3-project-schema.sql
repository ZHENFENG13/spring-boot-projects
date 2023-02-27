CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot3_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springboot3_db`;
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password_md5` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `user_token` varchar(50) NOT NULL DEFAULT '' COMMENT 'token值',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0未删除 1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_admin_user` (`id`, `user_name`, `password_md5`, `user_token`, `is_deleted`, `create_time`)
VALUES    (1,'admin','e10adc3949ba59abbe56e057f20f883e','6f1d93269e8bfdcd2066a248bfdafee6',0,'2023-01-01 11:50:13');

USE springboot3_db;
DROP TABLE IF EXISTS `tb_ssm_picture`;
CREATE TABLE `tb_ssm_picture` (
  `id` BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `path` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '图片路径',
  `remark` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '备注',
  `is_deleted` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '是否已删除 0未删除 1已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

USE springboot3_db;
DROP TABLE IF EXISTS `tb_ssm_article`;
CREATE TABLE `tb_ssm_article` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_title` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '文章标题',
  `article_content` text COLLATE utf8_bin NOT NULL COMMENT '文章内容',
  `add_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '添加人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;