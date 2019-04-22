package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
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
public interface StudentBusinessMapper {
    /**
     * 分页查询学生信息
     * @param pageInquire 分页信息
     * @return 查询到的学生信息
     */
    List<Student> findStudentPage(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 通过分页参数获取到学生信息的数量
     * @param pageInquire 分页信息
     * @return 查询到的学生数量
     */
    long findStudentCount(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 获取一个学生的详细信息
     * @param pageInquire 分页信息
     * @return 查询到的学生信息
     */
    List<StudentVo> findStudentVoPage(@Param(value = "pageInquire") StudentPageInquire pageInquire);

    /**
     * 通过老师id和课程id获取到学生信息
     * @param teacherId 老师id
     * @param courseId 课程id
     * @return 学生信息列表
     */
    List<StudentVo> findStudentByTeacherIdAndCourseId(@Param(value = "teacherId") Integer teacherId,
                                                      @Param(value = "courseId") Integer courseId);

}
