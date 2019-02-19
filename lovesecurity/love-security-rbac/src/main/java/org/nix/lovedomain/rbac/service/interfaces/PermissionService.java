package org.nix.lovedomain.rbac.service.interfaces;

import org.nix.lovedomain.rbac.bean.po.Permisson;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限服务
 * @date 2019/2/18
 */
public interface PermissionService {

    Integer add(Permisson permisson);

    Integer delete(Integer permissonId);

    Integer update(Permisson permisson);

    Permisson selectByPrimaryKey(Integer permissonId);

    List<Permisson> listPermissionWithParName(Permisson permisson);

    List<Permisson> listPermission(Permisson permisson);

    List<Permisson> listPermissionView();

    List<Permisson> getUserPermissons(Integer userId);

}
