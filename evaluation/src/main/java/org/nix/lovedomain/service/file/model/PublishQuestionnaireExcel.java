package org.nix.lovedomain.service.file.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布一个评教表需要从excel读取的数据
 * @date 2019/5/25
 */
@Data
public class PublishQuestionnaireExcel {

    /**
     * 黑名单数量
     */
    private Integer blacks;
    /**
     * 评教卷id
     */
    private Integer questionnaireId;
    /**
     * 教学任务id
     */
    private String teachCourseId;
    /**
     * 课程在学校的唯一编码
     */
    private String courseCoding;
    /**
     * 老师姓名
     */
    private String teacherName;
    /**
     * 学年
     */
    private Integer year;
    /**
     * 学期
     */
    private String semester;
    /**
     * 教学时间段，规则为 01-99,100-999的格式
     */
    private String teachTime;
    /**
     * 确定在课程多少周之前开始可以回答评教卷
     */
    private Integer evaluationTime;

    /**
     * 以教学任务为为一值进行过滤重复数据
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PublishQuestionnaireExcel that = (PublishQuestionnaireExcel) o;
        return Objects.equals(teachCourseId, that.teachCourseId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teachCourseId);
    }
}
