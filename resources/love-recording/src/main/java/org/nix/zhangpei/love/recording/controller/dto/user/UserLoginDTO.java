package org.nix.zhangpei.love.recording.controller.dto.user;

import org.nix.zhangpei.love.recording.controller.dto.CheckException;
import org.nix.zhangpei.love.recording.controller.dto.CheckRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class UserLoginDTO implements CheckRequest{

    private String username;

    private String password;

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
