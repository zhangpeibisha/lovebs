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
 * @date 2019/5/23
 */
@NameStyle
@Table(name = "account")
@Data
public class AccountModel {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String numbering;
    private String phone;
    private String email;
    private String password;
    private Date createTime;
    private Date updateTime;

}
