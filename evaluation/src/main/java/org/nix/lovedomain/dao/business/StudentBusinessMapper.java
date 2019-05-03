package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.service.vo.StudentVo;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生的业务mapper生成
 * @date 2019/4/7
 */
public interface StudentBusinessMapper extends BaseBusinessMapper<Student> {
    /**
     * 分页查询学生信息
     *
     * @param pageInquire 分页信息
     * @return 查询到的学生信息
     */
    List<Student> findStudentPage(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 通过分页参数获取到学生信息的数量
     *
     * @param pageInquire 分页信息
     * @return 查询到的学生数量
     */
    long findStudentCount(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 获取一个学生的详细信息
     *
     * @param pageInquire 分页信息
     * @return 查询到的学生信息
     */
    List<StudentVo> findStudentVoPage(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 通过老师id和课程id获取到学生信息
     *
     * @param teacherAccountId 老师账号id
     * @param courseId  课程id
     * @return 学生信息列表
     */
    List<StudentVo> findStudentByTeacherIdAndCourseId(@Param(value = "teacherAccountId") Integer teacherAccountId,
                                                      @Param(value = "courseId") Integer courseId);

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
}
