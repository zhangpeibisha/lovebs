package org.nix.zhangpei.love.recording.controller.dto.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.nix.zhangpei.love.recording.controller.dto.CheckException;
import org.nix.zhangpei.love.recording.controller.dto.CheckRequest;

import javax.validation.constraints.Pattern;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class UserLoginDTO implements CheckRequest{

    @Length(min = 6,max = 20,message = "用户名长度必须为6-20")
    @Pattern(regexp = "[a-zA-Z]{6,20}",message = "用户名应该为大小写字符组合大于等于6位小于20为")
    private String username;

    @Length(min = 32,max = 33)
    private String password;

    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",message = "手机号码格式不正确")
    private String phone;


    @Override
    public boolean pass() throws CheckException {
        if (password == null){
            throw new CheckException("登陆密码不能为空");
        }
        if (username == null && phone == null){
            throw new CheckException("用户名/手机号码不能为空");
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
