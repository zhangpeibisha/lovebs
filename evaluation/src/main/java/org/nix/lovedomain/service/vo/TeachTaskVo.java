package org.nix.lovedomain.service.vo;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.nix.lovedomain.dao.model.TeacherModel;

import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 教学内容展示数据
 * @date 2019/5/27
 */
@Data
public class TeachTaskVo {

    /**
     * 教学计划id
     */
    private String teachCourseId;
    /**
     * 学年
     */
    private Integer year;
    /**
     * 学期
     */
    private String semester;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 开始周
     */
    private Integer startWeek;
    /**
     * 结束周
     */
    private Integer endWeek;
    /**
     * 授课老师信息
     */
    private TeacherInfo teacher;
    /**
     * 课程信息
     */
    private CourseInfo course;

    /**
     * 发布的评教表id
     */
    private Integer publishQuestionnaireId;
    /**
     * 评教卷根本id
     */
    private Integer questionnaireId;

    public static TeachTaskVo teacherCourseModel2TaskVo(TeacherCourseModel teachCourseModel,
                                                        TeacherModel teacherModel,
                                                        CourseModel courseModel,
                                                        PublishQuestionnaireModel publishQuestionnaireModel) {
        TeachTaskVo teachTaskVo = new TeachTaskVo();


        Date endTime = teachCourseModel.getEndTime();
        teachTaskVo.setEndTime(DateUtil.format(endTime, "yyyy-MM-dd"));
        teachTaskVo.setEndWeek(teachCourseModel.getEndWeek());

        teachTaskVo.setSemester(teachCourseModel.getSemester());
        teachTaskVo.setYear(teachCourseModel.getSchoolYear());

        Date startTime = teachCourseModel.getStartTime();
        teachTaskVo.setStartTime(DateUtil.format(startTime, "yyyy-MM-dd"));
        teachTaskVo.setStartWeek(teachCourseModel.getStartWeek());

        teachTaskVo.setTeachCourseId(teachCourseModel.getTeachCourseId());

        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setAccountId(teacherModel.getAccountId());
        teacherInfo.setName(teacherModel.getName());
        teachTaskVo.setTeacher(teacherInfo);


        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setCourseId(courseModel.getId());
        courseInfo.setName(courseModel.getName());
        teachTaskVo.setCourse(courseInfo);

        teachTaskVo.setPublishQuestionnaireId(publishQuestionnaireModel.getId());
        Integer questionnaireId = publishQuestionnaireModel.getQuestionnaireId();
        teachTaskVo.setQuestionnaireId(questionnaireId);

        return teachTaskVo;
    }


    /**
     * 执行该教学计划的老师信息
     */
    @Data
    public static class TeacherInfo {
        /**
         * 老师的账号id
         */
        private Integer accountId;
        /**
         * 老师的名字
         */
        private String name;
    }

    /**
     * 教学计划对应的课程信息
     */
    @Data
    public static class CourseInfo {
        /**
         * 课程自增id
         */
        private Integer courseId;
        /**
         * 课程名字
         */
        private String name;
    }

}
