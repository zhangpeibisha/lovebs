package org.nix.lovedomain.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zhangpei
 * @version 1.0
 * @description 角色dto
 * @date 2019/4/19
 */
@Data
public class RoleDto {

    @NotBlank(message = "角色名字不能为空")
    private String name;

    private String description;

}
