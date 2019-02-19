package org.nix.lovedomain.rbac.dao;

import org.nix.lovedomain.rbac.bean.po.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int deleteByPrimaryKey(Integer roleId);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    List<Role> listRole(Role role);

    List<Role> listRoleByUserId(Integer userId);
}