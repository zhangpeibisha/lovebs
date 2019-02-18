package org.nix.lovedomain.rbac.dao;

import org.nix.lovedomain.rbac.bean.po.UserRole;

import java.util.List;

public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    Integer batchInsert(List<UserRole> userRoles);

    Integer deleteByUserId(Integer userId);

    List<UserRole> listUserRoles(UserRole userRole);
}