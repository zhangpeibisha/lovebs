package org.nix.zhangpei.love.recording.controller.dto.result;

import org.nix.zhangpei.love.recording.service.vo.UserVO;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/29
 */
public class UserInfoResult extends BaseResultDTO{

    private UserVO user;

    public UserInfoResult(String msg, Integer code, UserVO user) {
        super(msg, code);
        this.user = user;
    }

    public UserInfoResult(String msg, Integer code) {
        super(msg, code);
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfoResult{" +
                "user=" + user +
                '}';
    }
}
