/*
Navicat MySQL Data Transfer

Source Server         : zhoudongsheng
Source Server Version : 50724
Source Host           : 59.110.234.213:3306
Source Database       : evaluation

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-04-06 21:34:09
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '123456', null, null, '123456', '2019-03-07 05:59:16', '2019-03-07 06:43:36');

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
  KEY `account_role_roleId` (`roleId`),
  CONSTRAINT `account_role_accountId` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`),
  CONSTRAINT `account_role_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role
-- ----------------------------

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classId` int(11) DEFAULT NULL COMMENT '课程在学校的统一编码',
  `teacherId` int(11) DEFAULT NULL COMMENT '辅导老师id',
  `professionId` int(11) DEFAULT NULL COMMENT '专业id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `coding` varchar(50) NOT NULL COMMENT '课程在学校的统一编号',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `description` varchar(255) DEFAULT NULL COMMENT '课程描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for evaluationQuestionnaire
-- ----------------------------
DROP TABLE IF EXISTS `evaluationQuestionnaire`;
CREATE TABLE `evaluationQuestionnaire` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '评教题目',
  `descritption` varchar(255) DEFAULT NULL COMMENT '评教描述',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` text COMMENT '评教内容信息，里面包含了评教内容的所有信息',
  `authorId` int(11) DEFAULT NULL COMMENT '作者id-也就是teacher表中的老师id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluationQuestionnaire
-- ----------------------------

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coding` varchar(255) DEFAULT NULL COMMENT '学院在学校的统一编码',
  `name` varchar(255) DEFAULT NULL COMMENT '学院名字',
  `dean` int(11) DEFAULT NULL COMMENT '学院领导',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of faculty
-- ----------------------------

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` int(11) NOT NULL,
  `coding` varchar(255) DEFAULT NULL COMMENT '在学校的统一编码',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名字',
  `facultyId` int(11) DEFAULT NULL COMMENT '所属学院',
  `departmentId` int(11) DEFAULT NULL COMMENT '专业领导老师Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profession
-- ----------------------------

-- ----------------------------
-- Table structure for publishQuestionnaire
-- ----------------------------
DROP TABLE IF EXISTS `publishQuestionnaire`;
CREATE TABLE `publishQuestionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `releaseId` int(11) NOT NULL COMMENT '是谁发布这个评教卷的-在teachear表的老师，且拥有发布权限的老师',
  `courseId` int(11) NOT NULL COMMENT '这个评教卷是发布给哪个课程的',
  `teacherId` int(11) NOT NULL COMMENT '这个是授课老师id',
  `questionnaireId` int(11) NOT NULL COMMENT '评教卷id-对应评教卷表中的信息',
  `description` varchar(255) DEFAULT NULL COMMENT '对这次发布的解释',
  `releaseTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '什么时候发布的',
  `startRespondTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '‘学生什么时候开始回答这个评教卷’',
  `endRespondTime` timestamp NULL DEFAULT NULL COMMENT '‘学生什么时候禁止回答该评教卷’',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publishQuestionnaire
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaireAnswer
-- ----------------------------
DROP TABLE IF EXISTS `questionnaireAnswer`;
CREATE TABLE `questionnaireAnswer` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL COMMENT '学生id',
  `questionnaireResults` text NOT NULL COMMENT '评教卷调查结果，该结果以json格式存储',
  `semester` int(11) NOT NULL COMMENT '学生在第几学期回答的评教卷',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaireAnswer
-- ----------------------------

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL,
  `url` varchar(500) NOT NULL COMMENT '资源的url，可以写成 /user/**的格式',
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `use` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否启用 0标识启用 1标识禁用',
  `permissionAll` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0标识必须认证后才能访问 1标识可以不认证就可以访问',
  `method` varchar(20) NOT NULL DEFAULT 'GET' COMMENT 'url请求方法，默认为get方法',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_unq` (`url`,`method`) USING BTREE COMMENT 'url+请求方法是唯一的',
  KEY `name_key` (`name`) USING BTREE COMMENT '资源名字为索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_unq` (`name`) USING BTREE COMMENT '角色名字唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

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
  KEY `role_resource_resourceId` (`resourceId`),
  CONSTRAINT `role_resource_resourceId` FOREIGN KEY (`resourceId`) REFERENCES `resources` (`id`),
  CONSTRAINT `role_resource_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------

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
-- Records of scoreBlacklist
-- ----------------------------

-- ----------------------------
-- Table structure for statisticsScore
-- ----------------------------
DROP TABLE IF EXISTS `statisticsScore`;
CREATE TABLE `statisticsScore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) NOT NULL COMMENT '学生id',
  `courseId` int(11) NOT NULL COMMENT '课程id',
  `publishQuestionnaireId` int(11) NOT NULL COMMENT '评教卷发布id',
  `attachJson` text NOT NULL COMMENT '统计的一些附加信息',
  `fraction` int(11) NOT NULL COMMENT '授课老师得到的评分总和',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statisticsScore
-- ----------------------------

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
  `accountId` int(11) DEFAULT NULL COMMENT '账户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) DEFAULT NULL COMMENT '学生id',
  `courseId` int(11) DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobNumber` varchar(50) NOT NULL COMMENT '老师工号',
  `name` varchar(50) NOT NULL COMMENT '老师名字',
  `workJson` text NOT NULL COMMENT '老师工作需要使用的json字段，该字段可方便后续动态配置老师的工作需要的配置字段',
  `accountId` int(11) DEFAULT NULL COMMENT '账号id',
  `imagerUrl` varchar(255) NOT NULL DEFAULT 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg' COMMENT '老师头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) DEFAULT NULL COMMENT '老师id',
  `courseId` int(11) DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
