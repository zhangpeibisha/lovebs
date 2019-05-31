package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.StudentCourseModel;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生课程业务
 * @date 2019/5/12
 */
public interface StudentCourseBusinessMapper extends BaseBusinessMapper<StudentCourseModel> {

    /**
     * 更新一个学生的课程成绩
     *
     * @param score            成绩
     * @param studentAccountId 学生账户id
     * @param teachCourseId    教学任务id
     */
    @Update(value = "UPDATE student_course\n" +
            "SET score = #{score}\n" +
            "WHERE\n" +
            "\tstudentAccountId = #{studentAccountId}\n" +
            "AND teachCourseId = #{teachCourseId}")
    void updateStudentScore(@Param(value = "score") Integer score,
                            @Param(value = "studentAccountId") Integer studentAccountId,
                            @Param(value = "teachCourseId") String teachCourseId);

}
