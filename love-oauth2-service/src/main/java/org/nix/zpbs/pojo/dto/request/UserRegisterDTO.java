package org.nix.zpbs.pojo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 用户注册请求dto
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "UserRegisterDTO", description = "用户注册时使用的实体类")
public class UserRegisterDTO {

    @ApiModelProperty(value = "用户名字，不可以为空")
    @NotBlank(message = "无效的用户名或密码")
    private String userName;

    @ApiModelProperty(value = "用户密码，注册时不能为空")
    @Length(message = "无效的用户名或密码")
    @NotBlank(message = "密码不能为空")
    private String userPwd;

    @ApiModelProperty(value = "用户邮箱信息")
    @Email(message = "邮箱格式错误")
    private String userEmail;

    @ApiModelProperty(value = "用户手机信息")
    @DecimalMax(value = "99999999999",message = "手机号格式错误")
    private Long userPhone;

}
