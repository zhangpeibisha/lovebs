package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.dao.model.StudentModel;
import org.nix.lovedomain.service.vo.StudentVo;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生的业务mapper生成
 * @date 2019/4/7
 */
public interface StudentBusinessMapper extends BaseBusinessMapper<StudentModel> {
    /**
     * 分页查询学生信息
     *
     * @param pageInquire 分页信息
     * @return 查询到的学生信息
     */
    List<StudentModel> findStudentPage(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 通过分页参数获取到学生信息的数量
     *
     * @param pageInquire 分页信息
     * @return 查询到的学生数量
     */
    long findStudentCount(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 通过sql查询学生信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    List<StudentVo> findStudentBySql(@Param(value = "page") Integer page,
                                     @Param(value = "limit") Integer limit,
                                     @Param(value = "sql") String sql);

    /**
     * 通过sql查询学生数量
     * @param sql
     * @return
     */
    Long countStudentBySql(@Param(value = "sql") String sql);


    /**
     * 发现课程中在指定的学期中的上课信息
     * @param teacherAccountId 老师的账号id
     * @param courseId 课程id
     * @return
     */
    List<StudentModel> getStudentByTeachCourse(Integer teacherAccountId,
                                               Integer courseId);

    /**
     * 查看该教学任务有哪些学生参加
     * @param teachCourseId 教学任务id
     * @return 参加这个教学任务的学生信息
     */
    @Select(value = "SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tstudent AS s\n" +
            "LEFT JOIN student_course AS sc ON s.accountId = sc.studentAccountId\n" +
            "WHERE sc.teachCourseId = #{teachCourseId}")
    List<StudentModel> findStudentModelByTeachTaskId(@Param(value = "teachCourseId") String teachCourseId);

    /**
     * 通过学生的账号id获取到学生的信息
     * @param accountIds 学生的账号id集合
     * @return 学生信息
     */
    List<StudentModel> findStudentModelByAccountIds(@Param(value = "accountIds") List<Integer> accountIds);
}
