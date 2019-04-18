package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.RoleResourceBusinessMapper;
import org.nix.lovedomain.dao.mapper.RoleMapper;
import org.nix.lovedomain.model.Role;
import org.nix.lovedomain.web.dto.ResultDto;
import org.nix.lovedomain.web.dto.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限管理控制器
 * @date 2019/4/19
 */
@Slf4j
@RestController
@RequestMapping(value = "rbac")
public class RbacController {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    RoleResourceBusinessMapper roleResourceBusinessMapper;

    /**
     * 添加角色
     *
     * @param role 角色信息
     * @return 处理结果
     */
    @PostMapping(value = "/role")
    public ResultDto addRole(RoleDto role) {
        String name = role.getName();
        int i = roleMapper.insertSelective(
                JSONUtil.toBean(JSONUtil.toJsonStr(role), Role.class));
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

    /**
     * 为角色添加资源
     *
     * @param roleId      角色id
     * @param resourceIds 资源id集合
     * @return 操作结果
     */
    @PostMapping(value = "/role/{id}")
    public ResultDto addResourcesToRole(@PathVariable(value = "id") Integer roleId
            , @RequestParam(value = "resourceIds") List<Integer> resourceIds) {
        if (roleId == null || resourceIds == null) {
            return ResultDto.faile("角色id或者资源id不能为空");
        }
        roleResourceBusinessMapper.insertResourceToRole(roleId, resourceIds);
        return ResultDto.success("为角色添加资源成功");
    }

}
