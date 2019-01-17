package org.nix.zhangpei.love.recording.controller.dto.user;

import com.alibaba.fastjson.JSON;
import org.nix.zhangpei.love.recording.controller.dto.CheckException;
import org.nix.zhangpei.love.recording.controller.dto.CheckRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class UserUpdateDTO implements CheckRequest {

    private UserLoginDTO login;

    private String newUsername;

    private String newPhone;

    private String newPassword;

    public static void main(String[] args) {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setNewUsername("zhangpei520");
        UserLoginDTO loginDTO = new UserLoginDTO();
        loginDTO.setPhone("18203085236");
        loginDTO.setPassword("ee8b691327f83ccca32c4b85370d6c31");
        userUpdateDTO.setLogin(loginDTO);

        System.out.println(JSON.toJSONString(userUpdateDTO));
    }

    @Override
    public boolean pass() throws CheckException {
        if (newPassword == null && newPhone == null && newUsername == null){
            return false;
        }
        if (login == null){
            throw new CheckException("用户认证信息缺失");
        }
        return true;
    }

    public UserLoginDTO getLogin() {
        return login;
    }

    public void setLogin(UserLoginDTO login) {
        this.login = login;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UserUpdateDTO{" +
                "login=" + login +
                ", newUsername='" + newUsername + '\'' +
                ", newPhone='" + newPhone + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}