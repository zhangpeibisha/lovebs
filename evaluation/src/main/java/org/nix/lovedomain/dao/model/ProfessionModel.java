package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 专业信息
 * @author zhangpei
 */
@Entity
@Data
@NameStyle
@Table(name = "profession")
public class ProfessionModel implements Serializable {

    @Id
    private Integer id;

    /**
     * 在学校的统一编码
     *
     * @mbggenerated
     */
    private String coding;

    /**
     * 专业名字
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 所属学院
     *
     * @mbggenerated
     */
    private Integer facultyId;

    /**
     * 专业领导老师Id
     *
     * @mbggenerated
     */
    private Integer departmentId;

}