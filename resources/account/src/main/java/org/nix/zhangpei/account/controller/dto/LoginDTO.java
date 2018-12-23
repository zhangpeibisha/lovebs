package org.nix.zhangpei.account.controller.dto;

import org.nix.zhangpei.account.controller.dto.base.BaseDTO;
import org.nix.zhangpei.account.service.vo.LoginVO;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
public class LoginDTO extends BaseDTO {

    private LoginVO login;

    public LoginDTO(Boolean success, String msg, Integer code, LoginVO login) {
        super(success, msg, code);
        this.login = login;
    }

    public LoginVO getLogin() {
        return login;
    }

    public void setLogin(LoginVO login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(login, loginDTO.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), login);
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "login=" + login +
                ", success=" + success +
                ", msg='" + msg  +
                ", code=" + code +
                '}';
    }
}
