package org.nix.zhangpei.love.recording.controller.dto.user;

import org.nix.zhangpei.love.recording.controller.dto.CheckException;
import org.nix.zhangpei.love.recording.controller.dto.CheckRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class UserSelectDTO implements CheckRequest {

    private Long id;

    private String username;

    private String phone;

    @Override
    public boolean pass() throws CheckException {
        if (username != null){
            return true;
        }
        if (phone != null){
            return true;
        }
        if (id != null){
            return true;
        }
        throw new CheckException("查询信息不能为空");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserSelectDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
