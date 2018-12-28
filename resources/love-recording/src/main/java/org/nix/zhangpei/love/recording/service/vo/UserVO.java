package org.nix.zhangpei.love.recording.service.vo;

import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.nix.zhangpei.love.recording.dao.po.base.BasePO;
import org.nix.zhangpei.love.recording.service.vo.base.BaseVo;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class UserVO extends BaseVo {

    private String username;

    private String phone;

    public UserVO(UserPO userPO) {
        username = userPO.getUsername();
        phone = userPO.getPhone();
        BasePO basePO = userPO.getBasePO();
        setBaseVO(basePO);
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
        return "UserVO{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
