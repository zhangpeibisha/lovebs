package org.nix.zhangpei.love.recording.controller.dto.user;

import org.nix.zhangpei.love.recording.controller.dto.CheckException;
import org.nix.zhangpei.love.recording.controller.dto.CheckRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class UserRegisterDTO implements CheckRequest {

    private static final String IS_USER_NAME = "^[a-zA-Z]{6,16}$";

    private static final String IS_PHONE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
    /**
     * 1. 不能全是数字
     * 2. 不能全是字母
     * 3. 不能全是符号
     * 4. 长度不能少于8位
     */
    private static final String IS_PASSWORD = "(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}";

    /**
     * MD5加密后的长度
     */
    private static final Integer MD5_LEN = 32;

    private String username;

    private String phone;

    private String password;

    public static void main(String[] args) {
        System.out.println("18203085236".matches(IS_PHONE));
        System.out.println("zhangpei".matches(IS_USER_NAME));
    }

    @Override
    public boolean pass() throws CheckException {
        if (username == null || phone == null || password == null){
            throw new CheckException("用户名、手机号或者密码不能为空");
        }
        if (!username.matches(IS_USER_NAME)){
            throw new CheckException(String.format("用户名：%s使用格式不符合规范",username));
        }
        if (password.length()!=MD5_LEN){
            throw new CheckException("密码未经过加密进行传输");
        }
        if (!phone.matches(IS_PHONE)){
            throw new CheckException(String.format("手机号：%s使用格式不符合规范",phone));
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
