package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangpei
 * @version 1.0
 * @description 课程业务
 * @date 2019/5/11
 */
@Data
@Table(name = "course")
@NameStyle
public class CourseModel {

    @Id
    private Integer id;

    private String coding;

    private String name;

    private String description;


}
