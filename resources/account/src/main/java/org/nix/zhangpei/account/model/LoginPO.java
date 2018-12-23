package org.nix.zhangpei.account.model;

import org.nix.zhangpei.account.model.base.BasePO;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
public class LoginPO extends BasePO {
    private String phone;
    private String email;
    private String accountName;
    private String password;

    private LoginGroupPO group;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginGroupPO getGroup() {
        return group;
    }

    public void setGroup(LoginGroupPO group) {
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
        LoginPO loginPO = (LoginPO) o;
        return Objects.equals(phone, loginPO.phone) &&
                Objects.equals(email, loginPO.email) &&
                Objects.equals(accountName, loginPO.accountName) &&
                Objects.equals(password, loginPO.password) &&
                Objects.equals(group, loginPO.group);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), phone, email, accountName, password, group);
    }

    @Override
    public String toString() {
        return "LoginPO{" +
                "phone=" + phone +
                ", email='" + email + '\'' +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", group=" + group +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
