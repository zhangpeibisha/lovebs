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
@Table(name = "resources")
public class ResourcesModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String url;

    private String name;

    private String description;

    private Boolean use;

    private Boolean permissionAll;

    private String method;

}
