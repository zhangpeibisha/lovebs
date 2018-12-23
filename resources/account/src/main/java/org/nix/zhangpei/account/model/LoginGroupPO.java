package org.nix.zhangpei.account.model;

import org.nix.zhangpei.account.model.base.BasePO;

import java.util.List;
import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
public class LoginGroupPO extends BasePO {

    private String name;
    private String description;

    private List<LoginPO> logins;
    private List<RolePO> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LoginPO> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginPO> logins) {
        this.logins = logins;
    }

    public List<RolePO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolePO> roles) {
        this.roles = roles;
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
        LoginGroupPO that = (LoginGroupPO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(logins, that.logins) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, description, logins, roles);
    }

    @Override
    public String toString() {
        return "LoginGroupPO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", logins=" + logins +
                ", roles=" + roles +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
