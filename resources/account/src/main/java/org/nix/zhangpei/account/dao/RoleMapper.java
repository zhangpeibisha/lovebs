package org.nix.zhangpei.account.dao;


import org.nix.zhangpei.account.model.RolePO;
import org.springframework.stereotype.Repository;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
@Repository
public interface RoleMapper {
    /**
     * 添加角色
     * @param rolePO
     */
    void add(RolePO rolePO);

}
