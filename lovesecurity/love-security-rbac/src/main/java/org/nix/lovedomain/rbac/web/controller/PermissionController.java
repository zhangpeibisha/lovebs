package org.nix.lovedomain.rbac.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.nix.lovedomain.rbac.bean.po.Permisson;
import org.nix.lovedomain.rbac.service.interfaces.PermissionService;
import org.nix.lovedomain.rbac.util.ResponseEntity;
import org.nix.lovedomain.rbac.util.auth.core.extractor.PermissionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限控制器,框架默认使用节点
 * @date 2019/2/18
 */
@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/permission")
    @PermissionResource(name = "权限列表",description = "通过权限参数获取权限信息，分页查询")
    public ResponseEntity listPermissionWithParName(Permisson permisson, @RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pn, pageSize);
        List<Permisson> list = permissionService.listPermissionWithParName(permisson);
        PageInfo<Permisson> pageInfo = new PageInfo<>(list, 10);
        return ResponseEntity.success().add("pageInfo", pageInfo);
    }

    @GetMapping("/listPermission")
    @PermissionResource(name = "权限列表",description = "通过权限参数获取权限信息")
    public ResponseEntity listPermission(Permisson permisson) {
        List<Permisson> list = permissionService.listPermission(permisson);
        return ResponseEntity.success().add("list", list);
    }

    @PermissionResource(name = "权限列表",description = "通过权限参数获取权限信息")
    @GetMapping("/permission-view")
    public ResponseEntity listPermissionView() {
        List<Permisson> list = permissionService.listPermissionView();
        return ResponseEntity.success().add("list", list);
    }

    @PermissionResource(name = "添加或者更新权限信息",description = "通过权限参数添加或者更新权限信息")
    @PostMapping("/permission")
    public ResponseEntity addOrEditPermission(Permisson permission) {
        if (permission == null) {
            return ResponseEntity.error("参数错误");
        }
        //新增
        if (permission.getPermissonId() == null) {
            Integer result = permissionService.add(permission);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("新增失败");
            }
        } else {
            Integer result = permissionService.update(permission);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @PermissionResource(name = "删除资源",description = "通过权限参数删除资源")
    @DeleteMapping("/permission/{permissionId}")
    public ResponseEntity deletePermission(@PathVariable("permissionId") Integer permissionId) {
        Integer result = permissionService.delete(permissionId);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("删除失败");
        }
    }

    @PermissionResource(name = "查询资源信息",description = "通过权限参数查询资源信息")
    @GetMapping("/permission/{permissionId}")
    public ResponseEntity getPermission(@PathVariable("permissionId") Integer permissionId) {
        Permisson permisson = permissionService.selectByPrimaryKey(permissionId);
        return ResponseEntity.success().add("permisson", permisson);
    }
}
