package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import org.nix.lovedomain.dao.mapper.RoleMapper;
import org.nix.lovedomain.model.Role;
import org.nix.lovedomain.web.dto.ResultDto;
import org.nix.lovedomain.web.dto.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限管理控制器
 * @date 2019/4/19
 */
@RestController
@RequestMapping(value = "rbac")
public class RbacController {

    @Resource
    private RoleMapper roleMapper;

    @PostMapping(value = "/role")
    public ResultDto addRole(RoleDto role) {
        String name = role.getName();
        int i = roleMapper.insertSelective(
                JSONUtil.toBean(JSONUtil.toJsonStr(role),Role.class));
        if (i > 0) {
            ResultDto resultDto = new ResultDto();
            resultDto.setStatus(HttpStatus.OK);
            resultDto.setMsg(String.format("添加角色%s完成", name));
            return resultDto;
        }
        ResultDto resultDto = new ResultDto();
        resultDto.setStatus(HttpStatus.BAD_REQUEST);
        resultDto.setMsg(String.format("添加角色%s失败", name));
        return resultDto;
    }

}
