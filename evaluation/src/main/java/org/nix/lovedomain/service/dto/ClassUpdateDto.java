package org.nix.lovedomain.service.dto;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 班级更新值传输对象
 * @date 2019/6/2
 */
@Data
public class ClassUpdateDto {

    /**
     * 老师的账户id
     */
    private Integer teacherId;
    /**
     * 班级自增id
     */
    private Integer id;
    /**
     * 修改的专业信息
     */
    private Integer professionId;
    /**
     * 班级编号
     */
    private String classCoding;

}
