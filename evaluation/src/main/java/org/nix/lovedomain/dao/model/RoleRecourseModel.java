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
 * @description 资源和角色的对应关系
 * @date 2019/5/26
 */
@Data
@NameStyle
@Table(name = "role_resource")
public class RoleRecourseModel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer roleId;

    private Integer resourceId;

    private Date createTime;

    private Date updateTime;


}
