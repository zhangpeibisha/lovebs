package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
@NameStyle
@Table(name = "account_role")
@Data
public class AccountRoleModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer accountId;

    private Integer roleId;

    private Date createTime;

    private Date updateTime;

}
