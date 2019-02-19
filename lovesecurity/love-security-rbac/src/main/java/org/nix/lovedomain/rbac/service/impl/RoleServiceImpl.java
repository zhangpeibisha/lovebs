package org.nix.lovedomain.rbac.service.impl;

import org.nix.lovedomain.rbac.bean.po.Role;
import org.nix.lovedomain.rbac.bean.po.RolePermisson;
import org.nix.lovedomain.rbac.bean.vo.RolePermissonVO;
import org.nix.lovedomain.rbac.dao.RoleMapper;
import org.nix.lovedomain.rbac.dao.RolePermissonMapper;
import org.nix.lovedomain.rbac.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 角色服务实现
 * @date 2019/2/18
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissonMapper rolePermissonMapper;

    @Override
    public Integer add(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public Integer delete(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<Role> listRole(Role role) {
        return roleMapper.listRole(role);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<RolePermisson> listRolePermisson(Integer roleId) {
        return rolePermissonMapper.listRolePermisson(roleId);
    }

    @Override
    public List<RolePermissonVO> listRolePermissons(Integer roleId) {
        return rolePermissonMapper.listRolePermissons(roleId);
    }

    @Transactional
    @Override
    public Integer batchInsert(List<RolePermisson> rolePermissons) {
        RolePermisson rolePermisson = rolePermissons.get(0);
        rolePermissonMapper.deleteByRoleId(rolePermisson.getRoleId());
        return rolePermissonMapper.batchInsert(rolePermissons);
    }

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        return rolePermissonMapper.deleteByRoleId(roleId);
    }
}
