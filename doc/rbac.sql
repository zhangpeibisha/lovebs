-- 用户表
CREATE TABLE `user` (
   id int(8) not null auto_increment COMMENT '自增id',
  `usercode` varchar(32) NOT NULL COMMENT '账号',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `username` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `locked` char(1) DEFAULT 0 COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 角色表
CREATE TABLE `role` (
   id int(8) not null auto_increment COMMENT '自增id',
  `name` varchar(128) NOT NULL,
  `available` char(1) DEFAULT 1 COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 用户角色中间表
CREATE TABLE `user_role` (
   id int(8) not null auto_increment COMMENT '自增id',
  `user_id` int(8) NOT NULL,
  `role_id` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 权限表
CREATE TABLE `permission` (
   id int(8) not null auto_increment COMMENT '自增id',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `parentids` varchar(128) DEFAULT NULL COMMENT '父结点id列表串',
  `sortstring` varchar(128) DEFAULT NULL COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--  角色权限表
CREATE TABLE `role_permission` (
  id int(8) not null auto_increment COMMENT '自增id',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `permission_id` int(8) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
