package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/23
 */
@Data
@NameStyle
@Table(name = "faculty")
public class FacultyModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String coding;

    private String name;

    private Integer dean;

}
