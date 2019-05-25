package org.nix.lovedomain.service;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.RoleBusinessMapper;
import org.nix.lovedomain.dao.model.RoleModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangpei
 */
@Slf4j
@Service
public class RoleService {

    @Resource
    private RoleBusinessMapper roleBusinessMapper;

    /**
     * 通过角色名字找到角色信息
     *
     * @param name 角色名字
     * @return 角色信息
     */
    public RoleModel findRoleByName(String name) {
        RoleModel roleModel = new RoleModel();
        roleModel.setName(name);
        return roleBusinessMapper.selectOne(roleModel);
    }


}
