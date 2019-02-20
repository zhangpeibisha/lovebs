package org.nix.lovedomain.rbac.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.rbac.bean.po.Permisson;
import org.nix.lovedomain.rbac.bean.po.User;
import org.nix.lovedomain.rbac.bean.po.UserRole;
import org.nix.lovedomain.rbac.service.interfaces.PermissionService;
import org.nix.lovedomain.rbac.service.interfaces.UserService;
import org.nix.lovedomain.rbac.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户控制器
 * @date 2019/2/18
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;

    /**
     * @param userId 用户id
     * @return org.nix.lovedomain.rbac.util.ResponseEntity
     * @description 获取能访问的url信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/19
     */
    @GetMapping("/{user:[0-9]+}/permission")
    public ResponseEntity listPermission(@PathVariable(value = "user")Integer userId) {
        List<Permisson> userPermissons = permissionService.getUserPermissons(userId);
        String urls = userPermissons.stream().map(Permisson::getPermissonUrl).collect(Collectors.joining(","));
        log.info("获取用户{}的权限信息为{}",userId,urls);
        return ResponseEntity.success().add("urls",urls);
    }

    @GetMapping("/user")
    public ResponseEntity listUser(User user,
                                   @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pn, pageSize);
        List<User> list = userService.listUser(user);
        PageInfo<User> pageInfo = new PageInfo<>(list, 10);
        return ResponseEntity.success().add("pageInfo", pageInfo);
    }

    @PostMapping("/user")
    public ResponseEntity addOrEditUser(User user) {
        if (user == null) {
            return ResponseEntity.error("参数错误");
        }
        if (user.getUserId() == null) {//新增
            Integer result = userService.add(user);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("新增失败");
            }
        } else {
            Integer result = userService.update(user);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId) {
        Integer result = userService.delete(userId);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") Integer userId) {
        User user = userService.selectByPrimaryKey(userId);
        return ResponseEntity.success().add("user", user);
    }


    @PostMapping("/listUserRoles")
    public ResponseEntity listUserRoles(UserRole userRole) {
        List<UserRole> userRoles = userService.listUserRoles(userRole);
        StringBuilder ids = new StringBuilder();
        for (UserRole userRole1 : userRoles) {
            ids.append(userRole1.getRoleId()).append(",");
        }
        return ResponseEntity.success().add("roleIds", ids.substring(0, ids.length() - 1));
    }

}
