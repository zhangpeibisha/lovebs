package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.Id;
import javax.persistence.Table;
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
public class TeacherCourseModel {

    @Id
    private Integer id;

    private Integer teacherId;

    private Integer courseId;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private String startWeek;

    private Date endTime;

    private String endWeek;

    private Integer schoolYear;

    private String semester;

}
