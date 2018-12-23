package org.nix.zhangpei.account.dao;


import org.nix.zhangpei.account.model.RolePO;
import org.springframework.stereotype.Repository;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
@Repository
public class RoleMapping {
    private static RolePO role;

    private RoleMapping() {
    }

    public static RolePO getRole(){
        if (role == null){
            role = new RolePO();
            role.setDescription("系统所有者");
            role.setName("admin");
            role.setCreateTime(System.currentTimeMillis());
            role.setId(1L);
            role.setUpdateTIme(System.currentTimeMillis());
        }
        return role;
    }
}
