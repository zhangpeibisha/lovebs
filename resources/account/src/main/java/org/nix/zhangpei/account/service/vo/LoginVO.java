package org.nix.zhangpei.account.service.vo;

import org.nix.zhangpei.account.model.LoginGroupPO;
import org.nix.zhangpei.account.model.LoginPO;
import org.nix.zhangpei.account.service.vo.base.BaseVO;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
public class LoginVO extends BaseVO {

    private String phone;
    private String email;
    private String accountName;


    private LoginGroupVO group;

    public LoginVO(LoginPO loginPO) {
        phone = loginPO.getPhone();
        email = loginPO.getEmail();
        accountName = loginPO.getAccountName();
        group = new LoginGroupVO(loginPO.getGroup());
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LoginGroupVO getGroup() {
        return group;
    }

    public void setGroup(LoginGroupVO group) {
        this.group = group;
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
        LoginVO loginVO = (LoginVO) o;
        return Objects.equals(phone, loginVO.phone) &&
                Objects.equals(email, loginVO.email) &&
                Objects.equals(accountName, loginVO.accountName) &&
                Objects.equals(group, loginVO.group);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), phone, email, accountName, group);
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "phone=" + phone +
                ", email='" + email + '\'' +
                ", accountName='" + accountName + '\'' +
                ", group=" + group +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
