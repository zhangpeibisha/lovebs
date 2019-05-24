package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生
 * @date 2019/5/23
 */
@Data
@NameStyle
@Table(name = "student")
public class StudentModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String studentId;

    private String name;

    private String phone;

    private String email;

    private String imageUrl;
    private Integer classId;
    private Integer accountId;
    private String task;
    private Integer professionId;
    private Integer facultyId;

}
