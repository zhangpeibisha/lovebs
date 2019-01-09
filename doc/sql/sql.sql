-- ---------
-- user 用户表
-- ---------
CREATE TABLE user (
 user_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
 group_id bigint(8) NOT NULL COMMENT '用户组ID',
 user_name varchar(32) NOT NULL COMMENT '用户名',
 user_pwd varchar(32) NOT NULL COMMENT '用户密码',
 user_phone bigint(12) NOT NULL COMMENT '用户手机号码',
 user_sex varchar(6) NOT NULL COMMENT '用户性别',
 user_qq bigint(9) NOT NULL COMMENT '用户QQ号码',
 user_email varchar(64) NOT NULL COMMENT '用户EMAIL地址',
 user_address varchar(255) NOT NULL COMMENT '用户地址',
 user_mark bigint(9) NOT NULL COMMENT '用户积分',
 user_rank_id tinyint(3) NOT NULL COMMENT '用户等级',
 user_last_login_ip varchar(15) NOT NULL COMMENT '用户上一次登录IP地址',

 user_birthday bigint(13) NOT NULL COMMENT '用户生日',
 user_description varchar(255) NOT NULL COMMENT '自我描述',
 user_image_url varchar(255) NOT NULL COMMENT '用户头像存储路径',
 user_school varchar(255) NOT NULL COMMENT '毕业学校',
 user_register_time bigint(13) NOT NULL COMMENT '用户注册时间',
 user_register_ip varchar(15) NOT NULL COMMENT '用户注册时IP地址',
 user_last_update_time bigint(13) NOT NULL COMMENT '用户上次更新博客时间',
 user_weibo varchar(255) NOT NULL COMMENT '用户微博',
 user_blood_type char(3) NOT NULL COMMENT '用户血型',
 user_says varchar(255) NOT NULL COMMENT '用户语录',
 user_lock tinyint(3) NOT NULL COMMENT '是否锁定，0为不锁定，1为锁定',
 user_freeze tinyint(3) NOT NULL COMMENT '是否冻结，0为不冻结，1为冻结',
 user_power varchar(255) NOT NULL COMMENT '拥有权限',
 PRIMARY KEY (user_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- ---------------
-- user_rank 用户权限表
-- ---------------
CREATE TABLE user_rank (
 rank_id bigint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_rank_id smallint(5) NOT NULL COMMENT '等级ID',
 rank_mark bigint(6) NOT NULL COMMENT '等级积分',
 rank_name varchar(32) NOT NULL COMMENT '等级名称',
 PRIMARY KEY (rank_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- --------------
-- user_group 用户组表
-- --------------
CREATE TABLE user_group (
 g_id tinyint(3) NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
 group_id tinyint(3) NOT NULL COMMENT '用户组ID',
 group_name varchar(20) NOT NULL COMMENT '用户组名',
 group_power varchar(20) NOT NULL COMMENT '用户权限',
 PRIMARY KEY (g_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- ----------------
-- power_list 功能权限表
-- ----------------
CREATE TABLE power_list (
 p_id int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 power_id int(10) NOT NULL COMMENT '权限ID',
 power_name varchar(36) NOT NULL COMMENT '权限描述',
 PRIMARY KEY (p_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- -----------------
-- friend 好友表
-- -----------------
CREATE TABLE friend (
 f_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_id bigint(8) NOT NULL COMMENT '用户ID',
 friend_id bigint(8) NOT NULL COMMENT '好友ID',
 PRIMARY KEY (f_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- --------------------
-- user_attention 用户关注表
-- --------------------
CREATE TABLE user_attention (
 a_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_id bigint(8) NOT NULL COMMENT '用户ID',
 attention_id bigint(8) NOT NULL COMMENT '关注ID',
 PRIMARY KEY (a_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- ---------------------
-- secret_message 用户私信表
-- ---------------------
CREATE TABLE secret_message (
 secret_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '自增私信ID',
 send_id bigint(8) NOT NULL COMMENT '发信者ID',
 receive_id bigint(8) NOT NULL COMMENT '收信者ID',
 message_topic varchar(64) NOT NULL COMMENT '私信标题',
 message_content varchar(255) NOT NULL COMMENT '私信内容',
 PRIMARY KEY (secret_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- ----------------------
-- system_message 系统通知表
-- ----------------------
CREATE TABLE system_message (
 system_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '系统通知ID',
 send_id bigint(8) NOT NULL COMMENT '接受者ID',
 group_id tinyint(3) NOT NULL COMMENT '用户组ID',
 send_default bigint(8) NOT NULL COMMENT '1时发送所有用户，0时则不采用',
 system_topic varchar(60) NOT NULL COMMENT '通知内容',
 system_content varchar(255) NOT NULL COMMENT '通知内容',
 PRIMARY KEY (system_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- ------------------------
-- friendly_link 友情链接
-- ------------------------
CREATE TABLE friendly_link (
 link_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '友情链接自增ID',
 link_name varchar(60) NOT NULL COMMENT '友情链接名称',
 link_url varchar(255) NOT NULL COMMENT '链接地址',
 link_logo varchar(255) NOT NULL COMMENT 'LOGO图片',
 show_order tinyint(3) NOT NULL COMMENT '在页面显示的顺序',
 PRIMARY KEY (link_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- ------------------------
-- ad 广告表
-- ------------------------
CREATE TABLE ad (
 ad_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 position_id smallint(5) NOT NULL COMMENT '0,站外广告;从1开始代表的是该广告所处的广告位,同表ad_postition中的字段position_id的值',
 media_type tinyint(3) NOT NULL DEFAULT 0 COMMENT '广告类型,0图片;1flash;2代码3文字',
 ad_name varchar(60) NOT NULL COMMENT '该条广告记录的广告名称',
 ad_link varchar(255) NOT NULL COMMENT '广告链接地址',
 ad_code text NOT NULL COMMENT '广告链接的表现,文字广告就是文字或图片和flash就是它们的地址',
 start_time bigint(13) NOT NULL DEFAULT 0 COMMENT '广告开始时间',
 end_time bigint(13) NOT NULL DEFAULT 0 COMMENT '广告结束时间',
 link_man varchar(60) NOT NULL COMMENT '广告联系人',
 link_email varchar(60) NOT NULL COMMENT '广告联系人的邮箱',
 link_phone varchar(60) NOT NULL COMMENT '广告联系人得电话',
 click_count bigint(8) NOT NULL DEFAULT 0 COMMENT '广告点击次数',
 enabled tinyint(3) NOT NULL DEFAULT 1 COMMENT '该广告是否关闭;1开启; 0关闭; 关闭后广告将不再有效',
 PRIMARY KEY (ad_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- ------------------
-- stay_message 用户留言表
-- ------------------
CREATE TABLE stay_message (
 stay_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '留言表自增ID',
 user_id bigint(8) NOT NULL COMMENT '用户ID',
 stay_user_id bigint(8) NOT NULL COMMENT '留言者ID',
 message_content varchar(255) NOT NULL COMMENT '留言内容',
 stay_user_ip varchar(15) NOT NULL COMMENT '留言用户的IP地址',
 message_stay_time bigint(13) NOT NULL COMMENT '留言时间',
 place varchar(64) NOT NULL COMMENT '地区',
 PRIMARY KEY (stay_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;


-- --------------------
-- about_blog 博客信息表
-- --------------------
CREATE TABLE about_blog (
 blog_id bigint(8) NOT NULL  COMMENT '用户ID',
 blog_keyword varchar(255) NOT NULL COMMENT '博客关键字',
 blog_description varchar(255) NOT NULL COMMENT '博客描述',
 blog_name varchar(36) NOT NULL COMMENT '博客名称',
 blog_title varchar(128) NOT NULL COMMENT '博客标题',
 PRIMARY KEY (blog_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- ----------------------
-- visitor 最近访客表
-- ----------------------
CREATE TABLE visitor (
 v_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '访客记录ID',
 visitor_id bigint(8) NOT NULL COMMENT '访客ID',
 visitor_time bigint(13) NOT NULL COMMENT '来访时间',
 user_id bigint(8) NOT NULL COMMENT '被访用户ID',
 visitor_ip varchar(15) NOT NULL COMMENT '访客IP地址',
 type_id int(3) NOT NULL COMMENT '访问板块ID',
 where_id bigint(8) NOT NULL COMMENT '查看某板块的某个子项目，如查看相册板块的第3个相册，该ID对应该相册的ID号',
 PRIMARY KEY (v_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- -----------------------
-- shuoshuo 用户心情说说表
-- -----------------------
CREATE TABLE shuoshuo (
 shuo_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '说说记录ID',
 user_id bigint(8) NOT NULL COMMENT '用户ID',
 shuo_time bigint(13) NOT NULL DEFAULT 0 COMMENT '发布时间',
 shuo_ip varchar(15) NOT NULL COMMENT '说说发布时的IP地址',
 shuoshuo varchar(255) NOT NULL COMMENT '说说内容',
 type_id tinyint(3) NOT NULL DEFAULT 3 COMMENT '栏目ID,默认为3',
 PRIMARY KEY (shuo_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- -----------------------
-- photo_sort 相片分类表
-- -----------------------
CREATE TABLE photo_sort (
 sort_img_id bigint(8) NOT NULL  AUTO_INCREMENT COMMENT '相册ID',
 sort_img_name varchar(20) NOT NULL COMMENT '相册名',
 sort_img_type varchar(20) NOT NULL COMMENT '展示方式 0->仅主人可见,1->输入密码即可查看,2->仅好友能查看,3->回答问题即可查看',
 img_password varchar(32) NOT NULL COMMENT '查看密码',
 user_id bigint(8) NOT NULL COMMENT '所属用户ID',
 img_sort_question varchar(255) NOT NULL COMMENT '访问问题',
 img_sort_answer varchar(128) NOT NULL COMMENT '访问问题的答案',
 type_id int(3) NOT NULL DEFAULT 1 COMMENT '默认1表示相册板块',
 top_pic_src bigint(8) NOT NULL COMMENT '封面图片的路径',
 PRIMARY KEY (sort_img_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- -----------------------
-- photos 相片表
-- -----------------------
CREATE TABLE photos (
 photo_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '相片ID',
 photo_name varchar(255) NOT NULL COMMENT '相片名称',
 photo_src varchar(255) NOT NULL COMMENT '图片路径',
 photo_description varchar(255) NOT NULL COMMENT '图片描述',
 user_id bigint(8) NOT NULL COMMENT '所属用户ID',
 sort_id bigint(8) NOT NULL COMMENT '所属相册ID',
 upload_time bigint(13) NOT NULL COMMENT '图片上传时间',
 upload_ip varchar(15) NOT NULL COMMENT '图片操作上传IP地址',
 PRIMARY KEY (photo_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;




-- -------------------------
-- article_sort 文章分类表
-- -------------------------
CREATE TABLE article_sort (
 sort_article_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '文章自增ID',
 user_id bigint(8) NOT NULL COMMENT '该分类所属用户',
 sort_article_name varchar(60) NOT NULL COMMENT '分类名称',
 PRIMARY KEY (sort_article_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- --------------------------
-- article 文章表
-- --------------------------
CREATE TABLE article (
 article_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '日志自增ID号',
 article_name varchar(128) NOT NULL COMMENT '文章名称',
 article_time bigint(13) NOT NULL COMMENT '发布时间',
 article_ip varchar(15) NOT NULL COMMENT '发布IP',
 article_click int(10) NOT NULL COMMENT '查看人数',
 sort_article_id bigint(8) NOT NULL COMMENT '所属分类',
 user_id bigint(8) NOT NULL COMMENT '所属用户ID',
 type_id tinyint(3) NOT NULL DEFAULT 1 COMMENT '栏目ID',
 article_type int(13) NOT NULL DEFAULT 1 COMMENT '文章的模式:0为私有，1为公开，2为仅好友查看',
 article_content text NOT NULL COMMENT '文章内容',
 article_up tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否置顶:0为否，1为是',
 article_support tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否博主推荐:0为否，1为是',
 PRIMARY KEY (article_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;




-- --------------------------
-- user_comment 用户评论表
-- --------------------------
CREATE TABLE user_comment (
 c_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '评论自增ID号',
 user_id bigint(8) NOT NULL COMMENT '收到评论的用户ID',
 type_id tinyint(3) NOT NULL COMMENT '评论栏目ID',
 commit_id bigint(8) NOT NULL COMMENT '评论内容的ID',
 commit_content varchar(255) NOT NULL COMMENT '评论内容',
 commit_user_id bigint(8) NOT NULL COMMENT '评论者ID',
 commit_time bigint(13) NOT NULL COMMENT '评论时间',
 commit_ip varchar(15) NOT NULL COMMENT '评论时的IP地址',
 PRIMARY KEY (c_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;



-- ----------------------------
-- phone_message 短信记录表
-- ----------------------------
CREATE TABLE phone_message (
 phone_id bigint(8) NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
 phone_num varchar(12) NOT NULL COMMENT '用户手机号码',
 contents varchar(255) NOT NULL COMMENT '发送内容',
 send_time bigint(13) NOT NULL COMMENT '发送时间',
 user_id bigint(8) NOT NULL COMMENT '用户ID',
 PRIMARY KEY (phone_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ;