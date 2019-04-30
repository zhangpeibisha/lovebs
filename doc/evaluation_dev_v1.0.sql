/*
Navicat MySQL Data Transfer

Source Server         : 张沛
Source Server Version : 50724
Source Host           : 59.110.234.213:3306
Source Database       : evaluation_dev

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-04-30 12:08:45
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '123456', null, null, '123456', '2019-03-07 05:59:16', '2019-03-07 06:43:36');
INSERT INTO `account` VALUES ('2', 'laoshi', '18203085236', 'zhangpe0312@qq.com', 'laoshi', '2019-04-22 18:05:33', '2019-04-27 04:37:50');

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
  PRIMARY KEY (`id`),
  KEY `classId` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '115030902', '2', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '12', '线性代数', null);

-- ----------------------------
-- Table structure for evaluationQuestionnaire
-- ----------------------------
DROP TABLE IF EXISTS `evaluationQuestionnaire`;
CREATE TABLE `evaluationQuestionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '评教题目',
  `descritption` varchar(255) DEFAULT NULL COMMENT '评教描述',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` text COMMENT '评教内容信息，里面包含了评教内容的所有信息',
  `authorId` varchar(255) DEFAULT NULL COMMENT '作者id-也就是teacher表中的老师id(可能老师的账号、手机或者邮箱)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluationQuestionnaire
-- ----------------------------
INSERT INTO `evaluationQuestionnaire` VALUES ('20', '张沛创建问卷', null, '2019-04-20 18:20:53', '2019-04-27 03:27:14', null, '2');
INSERT INTO `evaluationQuestionnaire` VALUES ('21', '张沛创建问卷', null, '2019-04-21 03:17:36', '2019-04-27 03:00:27', '{\"questions\":[{\"id\":\"243de1616aef47bd9b53d7d80d6b0da0\",\"title\":\"11111\",\"prompt\":\"22222\",\"items\":[{\"id\":\"b371d2aa-00a6-4a6c-93b1-70b0a9d74e0c\",\"sort\":0,\"title\":\"1xxxxx\",\"prompt\":\"xxxxe\",\"mustWriter\":true}],\"questionnaireType\":\"CHOSE_SINGLE\",\"mustWriter\":true},{\"id\":\"e6296ab6625740ea858cc588db4596ff\",\"title\":\"111updatelallala11\",\"prompt\":\"22222\",\"items\":[{\"id\":\"7e7f5e85-d34f-4025-8374-596776b9f88f\",\"sort\":0,\"title\":\"updatexxxxx\",\"prompt\":\"我sssssde\",\"mustWriter\":true}],\"questionnaireType\":\"CHOSE_SINGLE\",\"mustWriter\":true}]}', '2');
INSERT INTO `evaluationQuestionnaire` VALUES ('22', '张沛创建问卷', null, '2019-04-21 03:27:54', '2019-04-27 03:00:30', '{\"questions\":[{\"id\":\"08376e7877a64f23a83547a3ef97e1e7\",\"title\":\"11111\",\"prompt\":\"22222\",\"items\":[{\"id\":\"344a4940-f373-4659-b27a-6119bd7744f6\",\"sort\":0,\"title\":\"1xxxxx\",\"prompt\":\"xxxxe\",\"mustWriter\":true}],\"questionnaireType\":\"CHOSE_SINGLE\",\"mustWriter\":true},{\"id\":\"716dd2bc9e8441d59598d54da0c8123f\",\"title\":\"11111\",\"prompt\":\"22222\",\"items\":[{\"id\":\"0e1bf369-0f4d-458b-9af7-dd74c176905b\",\"sort\":0,\"title\":\"1xxxxx\",\"prompt\":\"xxxxe\",\"mustWriter\":true}],\"questionnaireType\":\"CHOSE_SINGLE\",\"mustWriter\":true}]}', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of faculty
-- ----------------------------
INSERT INTO `faculty` VALUES ('1', '11503', '计算机科学与工程学院', '2');

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coding` varchar(255) DEFAULT NULL COMMENT '在学校的统一编码',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名字',
  `facultyId` int(11) DEFAULT NULL COMMENT '所属学院',
  `departmentId` int(11) DEFAULT NULL COMMENT '专业领导老师Id',
  PRIMARY KEY (`id`),
  KEY `coding` (`coding`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('1', '1150309', '网络工程', '1', '2');

-- ----------------------------
-- Table structure for publishQuestionnaire
-- ----------------------------
DROP TABLE IF EXISTS `publishQuestionnaire`;
CREATE TABLE `publishQuestionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `releaseId` int(11) NOT NULL COMMENT '是谁发布这个问卷的-在teachear表的老师，且拥有发布权限的老师',
  `courseId` int(11) NOT NULL COMMENT '这个问卷是发布给哪个课程的',
  `teacherId` int(11) NOT NULL COMMENT '这个是授课老师id',
  `questionnaireId` int(11) NOT NULL COMMENT '问卷id-对应问卷表中的信息',
  `description` varchar(255) DEFAULT NULL COMMENT '对这次发布的解释',
  `releaseTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '什么时候发布的，创建该条数据的时间',
  `startRespondTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '‘学生什么时候开始回答这个问卷’',
  `endRespondTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '‘学生什么时候禁止回答该问卷’',
  `statistics` text COMMENT '用于发布问卷统计使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publishQuestionnaire
-- ----------------------------
INSERT INTO `publishQuestionnaire` VALUES ('4', '2', '1', '2', '21', null, '2019-04-22 18:18:11', '2019-04-28 08:00:00', '1970-01-01 08:00:00', '{\"canFilters\":1,\"students\":[1],\"plan\":1}');
INSERT INTO `publishQuestionnaire` VALUES ('5', '2', '1', '2', '21', null, '2019-04-22 18:19:13', '2019-04-28 08:00:00', '1970-01-01 08:00:00', '{\"canFilters\":1,\"students\":[{\"studentId\":\"11503090207\",\"phone\":\"18203085236\",\"imageUrl\":\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg\",\"name\":\"张沛\",\"id\":1}],\"plan\":1}');

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
-- Records of questionnaireAnswer
-- ----------------------------

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(500) NOT NULL COMMENT '资源的url，可以写成 /user/**的格式',
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `use` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否启用 0标识启用 1标识禁用',
  `permissionAll` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0标识必须认证后才能访问 1标识可以不认证就可以访问',
  `method` varchar(20) NOT NULL DEFAULT 'GET' COMMENT 'url请求方法，默认为get方法',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_unq` (`url`,`method`) USING BTREE COMMENT 'url+请求方法是唯一的',
  KEY `name_key` (`name`) USING BTREE COMMENT '资源名字为索引'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('1', '/**', '全部资源', '超级管理员拥有', '1', '0', 'GET');
INSERT INTO `resources` VALUES ('2', '/**', '全部资源', '超级管理员拥有', '1', '0', 'POST');
INSERT INTO `resources` VALUES ('3', '/role/**', '角色管理', '', '1', '0', 'POST');
INSERT INTO `resources` VALUES ('4', '/role/**', '角色管理', '', '1', '0', 'GET');
INSERT INTO `resources` VALUES ('5', '/role/**', '角色管理', '', '1', '0', 'PUT');
INSERT INTO `resources` VALUES ('6', '/role/**', '角色管理', '', '1', '0', 'DELETE');
INSERT INTO `resources` VALUES ('7', '/resources/**', '资源管理者', '', '0', '0', 'GET');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '学生', null, '2019-04-23 16:53:06', '2019-04-23 16:53:06');
INSERT INTO `role` VALUES ('2', '老师', null, '2019-04-23 16:53:13', '2019-04-23 16:53:13');

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
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('4', '2', '2', '2019-04-18 18:44:47', '2019-04-18 18:44:47');

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
  `publishQuestionnaireId` int(11) NOT NULL COMMENT '问卷发布id',
  `attachJson` text NOT NULL COMMENT '统计的一些附加信息',
  `fraction` int(11) NOT NULL DEFAULT '0' COMMENT '授课老师得到的评分总和',
  `avg` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '平均分数',
  `classCoding` varchar(50) DEFAULT NULL COMMENT '班级编号',
  `professionCoding` varchar(50) DEFAULT NULL COMMENT '专业编号',
  `facultyCoding` varchar(50) DEFAULT NULL COMMENT '学院编号',
  `courseCoding` varchar(50) DEFAULT NULL COMMENT '课程编号',
  PRIMARY KEY (`id`),
  KEY `1` (`courseId`)
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
  `task` text COMMENT '学生的任务信息，为一个json字符串',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1150309020', '张沛', '18203085236', 'zhangpe0312@qq.com', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg', '1', '1', '{\"qnaireTask\":{\"total\":1,\"pending\":1,\"checked\":0,\"pendingDetail\":[{\"pastDue\":0,\"id\":5}],\"complete\":0}}');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) DEFAULT NULL COMMENT '学生id',
  `courseId` int(11) DEFAULT NULL COMMENT '课程id，对应着老师——课程id这个表的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('1', '1', '1');

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
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2', '12313', '罗颂', '{\"qnaireTask\":{\"total\":1,\"pending\":1,\"checked\":0,\"pendingDetail\":[{\"pastDue\":0,\"id\":5}],\"complete\":0}}', '2', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg', null, 'zhangpe0312@qq.com');

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) DEFAULT NULL COMMENT '老师id',
  `courseId` int(11) DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('1', '2', '1');
