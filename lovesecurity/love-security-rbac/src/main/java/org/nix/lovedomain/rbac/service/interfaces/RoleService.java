package org.nix.lovedomain.rbac.service.interfaces;

import org.nix.lovedomain.rbac.bean.po.Role;
import org.nix.lovedomain.rbac.bean.po.RolePermisson;
import org.nix.lovedomain.rbac.bean.vo.RolePermissonVO;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 角色服务
 * @date 2019/2/18
 */
public interface RoleService {

    Integer add(Role role);

    Integer delete(Integer roleId);

    Integer update(Role role);

    List<Role> listRole(Role role);

    Role selectByPrimaryKey(Integer roleId);

    List<RolePermisson> listRolePermisson(Integer roleId);

    List<RolePermissonVO> listRolePermissons(Integer roleId);

    Integer batchInsert(List<RolePermisson> rolePermissons);

    Integer deleteByRoleId(Integer roleId);

}
