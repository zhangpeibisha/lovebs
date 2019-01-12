package org.nix.zpbs.pojo.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * 用户注册请求dto
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
@Data
public class UserRegisterDTO {

    @NotEmpty(message = "无效的用户名或密码")
    private String userName;

    @Length(message = "无效的用户名或密码")
    private String password;

    private String email;

    private Long phone;

}
