package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.model.Student;

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


}
