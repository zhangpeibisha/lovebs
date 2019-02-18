package org.nix.lovedomain.rbac.bean.vo;

import org.nix.lovedomain.rbac.bean.po.Permisson;
import org.nix.lovedomain.rbac.bean.po.Role;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-11 14:11
 */
public class RolePermissonVO extends Role {

    private Permisson permisson;//角色拥有的权限

    public void setPermisson(Permisson permisson) {
        this.permisson = permisson;
    }

    public Permisson getPermisson() {
        return permisson;
    }
}
