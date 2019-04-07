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

    List<Student> findStudentPage(@Param(value = "pageInquire") StudentPageInquire pageInquire);


}
