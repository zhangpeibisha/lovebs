package org.nix.lovedomain.service.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布评教卷的请求参数
 * @date 2019/5/25
 */
@Data
public class PublishQuestionnaireArgs {
    /**
     * 教学任务id，学校为老师分配的教学任务
     */
    private String teachCourseId;
    /**
     * 课程的自增主键id
     */
    private Integer courseId;
    /**
     * 授课老师的账号id
     */
    private Integer teacherAccountId;
    /**
     * 评教卷的id
     */
    private Integer questionnaireId;
    /**
     * 发布的描述
     */
    private String description;
    /**
     * 开始回答的时间
     */
    private Date startRespondTime;
    /**
     * 结束回答的时间，一般为期末
     */
    private Date endRespondTime;
    /**
     * 黑名单数量，
     * 黑名单里面的学生回答的结果不作为分数统计
     */
    private Integer blacks;
    /**
     * 学年
     */
    private Integer year;

    /**
     * 学期信息
     */
    private String semester;

}
