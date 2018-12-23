package org.nix.zhangpei.account.service.vo;

import org.nix.zhangpei.account.model.LoginGroupPO;
import org.nix.zhangpei.account.model.LoginPO;
import org.nix.zhangpei.account.model.RolePO;
import org.nix.zhangpei.account.service.vo.base.BaseVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
public class LoginGroupVO extends BaseVO {

    private String name;
    private String description;

    private List<LoginVO> logins;
    private List<RoleVO> roles;

    public LoginGroupVO(LoginGroupPO group) {
        name = group.getName();
        description = group.getDescription();
        initLogins(group.getLogins());
        initRoles(group.getRoles());
    }

    private void initLogins(List<LoginPO> vos){
        List<LoginVO> loginVOs = new ArrayList<>();
        for (LoginPO loginPO : vos) {
            loginVOs.add(new LoginVO(loginPO));
        }
        logins = loginVOs;
    }

    private void initRoles(List<RolePO> rolePOS){
        List<RoleVO> vos = new ArrayList<>();
        for (RolePO rolePO : rolePOS) {
            vos.add(new RoleVO(rolePO));
        }
        roles = vos;
    }

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

    public List<LoginVO> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginVO> logins) {
        this.logins = logins;
    }

    public List<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVO> roles) {
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
        LoginGroupVO that = (LoginGroupVO) o;
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
        return "LoginGroupVO{" +
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
