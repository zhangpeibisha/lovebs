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
 * @date 2019/5/24
 */
@Data
@NameStyle
@Table(name = "role")
public class RoleModel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private String description;

    private Date createTime;

    private Date updateTime;

}
