package org.nix.zhangpei.account.dao;

import org.nix.zhangpei.account.model.LoginGroupPO;
import org.nix.zhangpei.account.model.LoginPO;
import org.nix.zhangpei.account.model.RolePO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
@Repository
public class LoginGroupMapping {

    private static LoginGroupPO group;

    private LoginGroupMapping() {
    }

    public static LoginGroupPO getGroup() {

        if (group == null){
            group = new LoginGroupPO();
            group.setName("admins");
            group.setDescription("系统所有者组");
            ArrayList<LoginPO> logins = new ArrayList<>();
            logins.add(LoginMapping.getLogin());
            group.setLogins(logins);
            ArrayList<RolePO> roles = new ArrayList<>();
            roles.add(RoleMapping.getRole());
            group.setRoles(roles);
            group.setCreateTime(System.currentTimeMillis());
            group.setId(1L);
            group.setUpdateTIme(System.currentTimeMillis());
        }
        return group;
    }
}
