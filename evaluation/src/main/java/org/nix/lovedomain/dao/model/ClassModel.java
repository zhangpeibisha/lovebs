package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhangpei
 * @version 1.0
 * @description 班级
 * @date 2019/5/23
 */
@Data
@NameStyle
@Table(name = "class")
public class ClassModel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String classCoding;

    private Integer teacherId;

    private Integer professionId;

}
