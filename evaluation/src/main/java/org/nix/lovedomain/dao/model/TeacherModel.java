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
 * @description 老师模型
 * @date 2019/5/23
 */
@Data
@NameStyle
@Table(name = "teacher")
public class TeacherModel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String jobNumber;

    private String name;

    private String workJson;

    private Integer accountId;

    private String imageUrl;

    private String phone;

    private String email;

    private Integer professionId;

}
