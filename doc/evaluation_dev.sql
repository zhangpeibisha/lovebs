/*
Navicat MySQL Data Transfer

Source Server         : zhangpei
Source Server Version : 50726
Source Host           : 47.102.214.252:3306
Source Database       : evaluation_dev

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-02 00:11:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numbering` varchar(20) NOT NULL COMMENT '用户在学校的唯一标识',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_numer_unq` (`numbering`) USING BTREE COMMENT '学校编号唯一',
  UNIQUE KEY `account_phone_unq` (`phone`) USING BTREE COMMENT '手机号唯一',
  UNIQUE KEY `account_email_unq` (`email`) USING BTREE COMMENT '邮箱唯一'
) ENGINE=InnoDB AUTO_INCREMENT=34215 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `account_role_accountId` (`accountId`),
  KEY `account_role_roleId` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=38362 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classCoding` varchar(11) DEFAULT NULL COMMENT '课程在学校的统一编码',
  `teacherId` int(11) DEFAULT NULL COMMENT '辅导老师id',
  `professionId` int(11) DEFAULT NULL COMMENT '专业id',
  PRIMARY KEY (`id`),
  KEY `classId` (`classCoding`)
) ENGINE=InnoDB AUTO_INCREMENT=11295 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coding` varchar(50) NOT NULL COMMENT '课程在学校的统一编号',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `description` varchar(255) DEFAULT NULL COMMENT '课程描述',
  PRIMARY KEY (`id`),
  KEY `coding` (`coding`)
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for evaluationQuestionnaire
-- ----------------------------
DROP TABLE IF EXISTS `evaluationQuestionnaire`;
CREATE TABLE `evaluationQuestionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '评教题目',
  `description` varchar(255) DEFAULT NULL COMMENT '评教描述',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` text COMMENT '评教内容信息，里面包含了评教内容的所有信息',
  `authorAccountId` varchar(255) DEFAULT NULL COMMENT '作者的账号id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coding` varchar(255) DEFAULT NULL COMMENT '学院在学校的统一编码',
  `name` varchar(255) DEFAULT NULL COMMENT '学院名字',
  `dean` int(11) DEFAULT NULL COMMENT '学院领导',
  PRIMARY KEY (`id`),
  KEY `coding` (`coding`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coding` varchar(255) DEFAULT NULL COMMENT '在学校的统一编码',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名字',
  `facultyId` int(11) DEFAULT NULL COMMENT '所属学院',
  `departmentId` int(11) DEFAULT NULL COMMENT '专业领导老师账号Id',
  PRIMARY KEY (`id`),
  KEY `coding` (`coding`)
) ENGINE=InnoDB AUTO_INCREMENT=1749 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for publishQuestionnaire
-- ----------------------------
DROP TABLE IF EXISTS `publishQuestionnaire`;
CREATE TABLE `publishQuestionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `releaseAccountId` int(11) NOT NULL COMMENT '是谁发布这个问卷的-在teachear表的老师，且拥有发布权限的老师',
  `courseId` int(11) NOT NULL COMMENT '这个问卷是发布给哪个课程的',
  `teacherAccountId` int(11) NOT NULL COMMENT '这个是授课老师的账号id',
  `questionnaireId` int(11) NOT NULL COMMENT '问卷id-对应问卷表中的信息',
  `description` varchar(255) DEFAULT NULL COMMENT '对这次发布的解释',
  `releaseTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '什么时候发布的，创建该条数据的时间',
  `startRespondTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '‘学生什么时候开始回答这个问卷’',
  `endRespondTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '‘学生什么时候禁止回答该问卷’',
  `statistics` text COMMENT '用于发布问卷统计使用',
  `year` int(11) DEFAULT NULL COMMENT '学年',
  `semester` varchar(255) DEFAULT NULL COMMENT '学期',
  `teachCourseId` varchar(255) DEFAULT NULL COMMENT '教学任务id，学校分配给老师的教学任务的唯一id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for questionnaireAnswer
-- ----------------------------
DROP TABLE IF EXISTS `questionnaireAnswer`;
CREATE TABLE `questionnaireAnswer` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL COMMENT '学生id',
  `questionnaireResults` text NOT NULL COMMENT '问卷调查结果，该结果以json格式存储',
  `semester` int(11) NOT NULL COMMENT '学生在第几学期回答的问卷',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facultyId` int(11) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(500) NOT NULL COMMENT '资源的url，可以写成 /user/**的格式',
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `enable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否启用 0标识启用 1标识禁用',
  `method` varchar(100) NOT NULL DEFAULT 'GET' COMMENT 'url请求方法，默认为get方法',
  PRIMARY KEY (`id`),
  KEY `name_key` (`name`) USING BTREE COMMENT '资源名字为索引',
  KEY `url_unq` (`url`,`method`) USING BTREE COMMENT 'url+请求方法是唯一的'
) ENGINE=InnoDB AUTO_INCREMENT=386 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_unq` (`name`) USING BTREE COMMENT '角色名字唯一'
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `resourceId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `role_resource_roleId` (`roleId`),
  KEY `role_resource_resourceId` (`resourceId`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scoreBlacklist
-- ----------------------------
DROP TABLE IF EXISTS `scoreBlacklist`;
CREATE TABLE `scoreBlacklist` (
  `id` int(11) NOT NULL,
  `courseId` int(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL COMMENT '授课老师id',
  `studentIds` varchar(255) DEFAULT NULL COMMENT '学生id集合，如果有学生id在这里面，则表示在给老师统计评教评分时不加入该学生的评教信息。学生id以逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for statisticsScore
-- ----------------------------
DROP TABLE IF EXISTS `statisticsScore`;
CREATE TABLE `statisticsScore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherAccountId` int(11) NOT NULL COMMENT '老师id',
  `courseId` int(11) NOT NULL COMMENT '课程id',
  `publishQuestionnaireId` int(11) NOT NULL COMMENT '问卷发布id',
  `attachJson` text NOT NULL COMMENT '统计的一些附加信息',
  `score` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '统计的分数',
  `type` int(11) DEFAULT NULL COMMENT ' 1 代表问卷的总分统计\r\n 2 代表问卷的平均分统计  总分/（总人数-黑名单生数量）\r\n 3 代表每项平均分\r\n 4 代表每个想被多少人统计',
  PRIMARY KEY (`id`),
  KEY `1` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(50) NOT NULL COMMENT '学生在学校的唯一id',
  `name` varchar(50) NOT NULL COMMENT '学生名字',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `imageUrl` varchar(255) NOT NULL DEFAULT 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg' COMMENT '用户头像',
  `classId` int(11) NOT NULL COMMENT '用户所在班级',
  `accountId` int(11) NOT NULL COMMENT '账户id',
  `task` text COMMENT '学生的任务信息，为一个json字符串',
  `professionId` int(11) DEFAULT NULL COMMENT '专业',
  `facultyId` int(11) DEFAULT NULL COMMENT '学院',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32663 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentAccountId` int(11) DEFAULT NULL COMMENT '学生的账号id',
  `teachCourseId` varchar(11) DEFAULT NULL COMMENT '对应teacher_course表中的teachCourseId值',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `score` int(11) DEFAULT NULL COMMENT '学生课程得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18998 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobNumber` varchar(50) NOT NULL COMMENT '老师工号',
  `name` varchar(50) NOT NULL COMMENT '老师名字',
  `workJson` text COMMENT '老师工作需要使用的json字段，该字段可方便后续动态配置老师的工作需要的配置字段',
  `accountId` int(11) NOT NULL COMMENT '账号id',
  `imageUrl` varchar(255) DEFAULT 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg' COMMENT '老师头像',
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `professionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=733 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherAccountId` int(11) NOT NULL COMMENT '老师账号id',
  `courseId` int(11) NOT NULL COMMENT '课程自增id',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '课程开始时间的时间戳',
  `startWeek` int(255) NOT NULL COMMENT '课程在这个学期的第几周开始',
  `endTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '课程结束的时间戳',
  `endWeek` int(255) NOT NULL COMMENT '课程结束的第几周',
  `schoolYear` varchar(255) NOT NULL COMMENT '学年，指的是年份，年份以第一学期的年为基础',
  `semester` varchar(255) NOT NULL COMMENT '学期，目前只有第二学期和第一学期',
  `teachCourseId` varchar(255) DEFAULT NULL COMMENT '课程计划号，在学校里面的授课课程唯一编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8;
