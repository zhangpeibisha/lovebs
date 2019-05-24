package org.nix.lovedomain.utils;

import cn.hutool.core.util.StrUtil;

/**
 * @version 1.0
 * @anthor on 2019/5/16
 * @since jdk8
 *
 *邮件内容
 */
public enum EmailContent {

    /**
     * 发送 开始 消息给发布的老师
     */
    SEND_PT_START("你好{}：你发布的评教卷{}已经开始答卷，你对评教卷的作用描述为：{},具体信息可以登陆【重庆理工大学评教系统】查看"),

    /**
     * 发送 开始 消息给授课老师
     */
    SEND_T_START("你好{}：你的教学质量评分已经开始，本次提醒所在课程：{}，你可以登陆【重庆理工大学评教系】的个人中心进行查看"),

    /**
     * 发送 开始 消息给上该门课的学生
     */
    SEND_S_START("你好：你上了{}老师的课程:{}，为了提高学校教学质量，现在请你根据你的学习情况和老师的授课情况公平公正的给与老师打分"),

    /**
     * 发送 结束 消息给发布的老师
     */
    SEND_PT_END("你好{}：你发布的评教卷{}已经结束答卷，你对评教卷的作用描述为：{},具体信息可以登陆【重庆理工大学评教系统】查看"),

    /**
     * 发送 结束 消息给授课老师
     */
    SEND_T_END("你好{}：你的教学质量评分已经结束，本次提醒所在课程：{}，你可以登陆【重庆理工大学评教系】的个人中心进行查看"),

    /**
     * 发送 结束 消息给上该门课的学生
     */
    SEND_S_END("你好：你参与的{}老师的课程:{}，已经结束答卷");

    private String message;

    EmailContent(String message){
        this.message = message;
    }

    /**
     * 内容填充
     * @param params
     * @return
     */
    public String toContent(Object... params){
       return StrUtil.format(this.message,params);
    }
}
