package org.nix.lovedomain.service.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.nix.lovedomain.dao.model.CourseModel;

import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布评教卷展示
 * @date 2019/5/1
 */
@Data
public class PublishQuestionVo {
    /**
     * 发布id
     */
    private Integer id;
    /**
     * 授课老师信息
     */
    private TeacherVo teacher;
    /**
     * 发布评教卷老师信息
     */
    private TeacherVo release;
    /**
     * 课程信息
     */
    private CourseModel course;
    /**
     * 评教卷信息
     */
    private EvaluationalSimpleVo questionnaire;
    /**
     * 发布描述
     */
    private String description;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 开始回答时间
     */
    private Date startRespondTime;
    /**
     * 结束答卷时间
     */
    private Date endRespondTime;
    /**
     * 统计字段
     */
    private JSONObject statistics;
}
