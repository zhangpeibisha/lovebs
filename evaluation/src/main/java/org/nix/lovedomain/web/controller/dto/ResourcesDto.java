package org.nix.lovedomain.web.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源dto
 * @date 2019/4/27
 */
@Data
public class ResourcesDto {

    /**
     * 资源的url，可以写成 /user/**的格式
     *
     * @mbggenerated
     */
    @NotBlank(message = "资源路径不能为空")
    private String url;

    @NotBlank(message = "资源路径不能为空")
    private String name;

    private String description;

    /**
     * 是否启用 0标识启用 1标识禁用
     *
     * @mbggenerated
     */
    private Byte use;

    /**
     * 0标识必须认证后才能访问 1标识可以不认证就可以访问
     *
     * @mbggenerated
     */
    private Byte permissionall;

    /**
     * url请求方法，默认为get方法
     *
     * @mbggenerated
     */
    private List<String> method;

}
