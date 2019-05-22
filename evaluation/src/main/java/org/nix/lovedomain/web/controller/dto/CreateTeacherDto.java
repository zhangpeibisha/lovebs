package org.nix.lovedomain.web.controller.dto;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 创建老师
 * @date 2019/5/11
 */
@Data
public class CreateTeacherDto {

    private String jobNumber;

    private String name;

    private String phone;

    private String email;

    private Integer professionId;

}
