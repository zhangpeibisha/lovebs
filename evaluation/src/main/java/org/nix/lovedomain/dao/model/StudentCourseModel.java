package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生课程业务
 * @date 2019/5/12
 */
@Data
@NameStyle
@Table(name = "student_course")
public class StudentCourseModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer studentId;

    private Integer teachCourseId;

    private Date createTime;

    private Date updateTime;

}
