package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/12
 */
@NameStyle
@Table(name = "teacher_course")
@Data
public class TeacherCourseModel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer teacherAccountId;

    private Integer courseId;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Integer startWeek;

    private Date endTime;

    private Integer endWeek;

    private Integer schoolYear;

    private String semester;

    /**
     * 在学校的唯一老师授课，课程号
     */
    private String teachCourseId;

}
