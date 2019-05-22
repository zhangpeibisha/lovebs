package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师模型
 * @date 2019/5/23
 */
@Data
@NameStyle
@Table(name = "teacher")
public class TeacherModel {

    @Id
    private Integer id;

    private String jobNumber;

    private String name;

    private String workJson;

    private Integer accountId;

    private String imagerUrl;

    private String phone;

    private String email;

    private Integer professionId;

}
