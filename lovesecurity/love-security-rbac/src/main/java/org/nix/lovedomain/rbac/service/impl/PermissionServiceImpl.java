package org.nix.lovedomain.rbac.service.impl;

import org.nix.lovedomain.rbac.bean.po.Permisson;
import org.nix.lovedomain.rbac.dao.PermissonMapper;
import org.nix.lovedomain.rbac.service.interfaces.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-09 15:48
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissonMapper permissonMapper;

    @Override
    public Integer add(Permisson permisson) {
        return permissonMapper.insertSelective(permisson);
    }

    @Override
    public Integer delete(Integer permissonId) {
        return permissonMapper.deleteByPrimaryKey(permissonId);
    }

    @Override
    public Integer update(Permisson permisson) {
        return permissonMapper.updateByPrimaryKeySelective(permisson);
    }

    @Override
    public Permisson selectByPrimaryKey(Integer permissonId) {
        return permissonMapper.selectByPrimaryKey(permissonId);
    }

    @Override
    public List<Permisson> listPermissionWithParName(Permisson permisson) {
        return permissonMapper.listPermissionWithParName(permisson);
    }

    @Override
    public List<Permisson> listPermission(Permisson permisson) {
        return permissonMapper.listPermission(permisson);
    }

    @Override
    public List<Permisson> listPermissionView() {
        return permissonMapper.listPermissionView();
    }

    @Override
    public List<Permisson> getUserPermissons(Integer userId) {
        return permissonMapper.getUserPermissons(userId);
    }

}
