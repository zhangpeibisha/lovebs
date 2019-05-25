package org.nix.lovedomain.service.file.model;

import cn.hutool.core.lang.Validator;
import lombok.Data;
import org.nix.lovedomain.service.enums.SemesterEnum;

import java.util.Date;
import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 教学任务
 * @date 2019/5/24
 */
@Data
public class TeachTaskExcel {

    /**
     * 课程在学校的编号
     */
    private String courseCoding;
    /**
     * 课程的名字
     */
    private String courseName;
    /**
     * 班级在学校的编号
     */
    private String classCoding;
    /**
     * 该此教学计划的开始和结束周时间
     * 需要用该时间来确定如何开始做教学测评
     */
    private String teachTime;

    /**
     * 该此教学计划执行的老师
     */
    private String teacherName;
    /**
     * 该计划所属专业
     */
    private String professionName;

    /**
     * 教学计划唯一id，是学校进行编码
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
     * 在课程结束的前几周开始可以回答
     * 测评。
     */
    private Integer evaluationTime;

    /**
     * 获取到教学时间的开始周时间
     *
     * @return 开始周的信息
     */
    public int findTeachStartWeek() {
        Validator.validateNotNull(teachTime, "课程计划{}教学时间不能为空", teachCourseId);
        String[] split = teachTime.split("-");
        return Integer.parseInt(split[0]);
    }

    /**
     * 获取教学时间的结束周时间
     *
     * @return 结束周的时间
     */
    public int findTeachEndWeek() {
        Validator.validateNotNull(teachTime, "课程计划{}教学时间不能为空", teachCourseId);
        String[] split = teachTime.split(",");
        String target = split[split.length - 1];
        return Integer.parseInt(target.split("-")[1]);
    }

    /**
     * @return 发现课程开始的时间，以时间标识
     */
    public Date findTeachStartTime() {
        return SemesterEnum.semesterWeekTime(year, semester, findTeachStartWeek());
    }

    /**
     * @return 发现课程结束的时间，以时间标识
     */
    public Date findTeachEndTime() {
        return SemesterEnum.semesterWeekTime(year, semester, findTeachEndWeek());
    }

    /**
     * @return 获取到开始回答教学质量评价卷的时间
     */
    public Date findReplyStartTime() {
        int teachStartWeek = findTeachStartWeek();
        int teachEndWeek = findTeachEndWeek();
        Validator.validateTrue(teachEndWeek > teachStartWeek,
                "课程计划{}开始周{}不能大于结束周{}", teachCourseId, teachStartWeek, teachEndWeek);
        int courseWeekNumber = teachEndWeek - teachStartWeek;
        int startEvaluationWeek = teachEndWeek - evaluationTime;
        Validator.validateTrue(courseWeekNumber > evaluationTime,
                "评教时间第{}周，课程计划开始第{}周，不允许提前",
                startEvaluationWeek, teachStartWeek);
        return SemesterEnum.semesterWeekTime(year, semester, startEvaluationWeek);
    }

    /**
     * 以教学计划为唯一值
     *
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
        TeachTaskExcel that = (TeachTaskExcel) o;
        return Objects.equals(teachCourseId, that.teachCourseId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teachCourseId);
    }
}
