package org.nix.lovedomain.rbac.dao;

import org.nix.lovedomain.rbac.bean.po.Permisson;

import java.util.List;

public interface PermissonMapper {

    int deleteByPrimaryKey(Integer permissonId);

    int insertSelective(Permisson record);

    Permisson selectByPrimaryKey(Integer permissonId);

    int updateByPrimaryKeySelective(Permisson record);

    List<Permisson> listPermissionWithParName(Permisson permisson);

    List<Permisson> listPermission(Permisson permisson);

    List<Permisson> listPermissionView();

    List<Permisson> getUserPermissons(Integer userId);
}