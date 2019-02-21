package org.nix.lovedomain.rbac.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.nix.lovedomain.rbac.bean.po.Role;
import org.nix.lovedomain.rbac.bean.po.RolePermisson;
import org.nix.lovedomain.rbac.service.interfaces.RoleService;
import org.nix.lovedomain.rbac.util.ResponseEntity;
import org.nix.lovedomain.rbac.util.auth.core.extractor.PermissionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangpei
 * @version 1.0
 * @description 角色控制器
 * @date 2019/2/18
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 查询角色列表
     *
     * @param role         查询参数
     * @param pn           页码
     * @param pageSize     每页显示数量
     * @param notAllowPage 不允许分页 参数大于0时生效
     * @return
     */
    @GetMapping("/role")
    @PermissionResource(name = "角色列表",description = "分页查询角色列表")
    public ResponseEntity listRole(Role role, @RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam(value = "notAllowPage", defaultValue = "0") Integer notAllowPage) {
        if (notAllowPage > 0) {
            List<Role> list = roleService.listRole(role);
            return ResponseEntity.success().add("list", list);
        } else {
            PageHelper.startPage(pn, pageSize);
            List<Role> list = roleService.listRole(role);
            PageInfo<Role> pageInfo = new PageInfo<>(list, 10);
            return ResponseEntity.success().add("pageInfo", pageInfo);
        }
    }

    @PostMapping("/role")
    @PermissionResource(name = "添加或者更新角色信息",description = "添加或者更新角色信息")
    public ResponseEntity addOrEditRole(Role role) {
        if (role == null) {
            return ResponseEntity.error("参数错误");
        }
        //新增
        if (role.getRoleId() == null) {
            Integer result = roleService.add(role);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("新增失败");
            }
        } else {
            Integer result = roleService.update(role);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @PermissionResource(name = "删除角色",description = "根据角色id删除角色")
    @DeleteMapping("/role/{roleId}")
    public ResponseEntity deleteRole(@PathVariable("roleId") Integer roleId) {
        Integer result = roleService.delete(roleId);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/role/{roleId}")
    @PermissionResource(name = "查询角色",description = "根据角色id查询角色")
    public ResponseEntity getRole(@PathVariable("roleId") Integer roleId) {
        Role role = roleService.selectByPrimaryKey(roleId);
        return ResponseEntity.success().add("role", role);
    }


    /**
     * 根据角色ID获取此角色拥有的权限Id的集合
     *
     * @param roleId
     * @return
     */
    @GetMapping("/role-permission/{roleId}")
    @PermissionResource(name = "获取角色权限",description = "根据角色id获取角色权限")
    public ResponseEntity getRolePermission(@PathVariable("roleId") Integer roleId) {
        List<RolePermisson> rolePermissons = roleService.listRolePermisson(roleId);
        List<Integer> permissonIds = rolePermissons.stream().map(RolePermisson::getPermissonId).collect(Collectors.toList());
        return ResponseEntity.success().add("permissonIds", permissonIds);
    }

    @PostMapping(value = "/role-authorization/{roleId}")
    @PermissionResource(name = "添加角色权限",description = "根据角色id添加角色权限")
    public ResponseEntity roleAuthorization(@PathVariable("roleId") Integer roleId, @RequestParam("permissonIds[]") Integer[] permissonIds) {
        List<Integer> ids = Arrays.asList(permissonIds);
        List<RolePermisson> list = new ArrayList<>();
        RolePermisson rolePermisson = null;
        for (Integer id : ids) {
            rolePermisson = new RolePermisson();
            rolePermisson.setRoleId(roleId);
            rolePermisson.setPermissonId(id);
            list.add(rolePermisson);
        }
        Integer result = roleService.batchInsert(list);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("授权失败！");
        }
    }
}
