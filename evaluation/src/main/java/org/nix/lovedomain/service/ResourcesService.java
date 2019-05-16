package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.ResoucesBusinessMapper;
import org.nix.lovedomain.dao.mapper.ResourcesMapper;
import org.nix.lovedomain.dao.mapper.RoleResourceMapper;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.SQLUtil;
import org.nix.lovedomain.web.controller.dto.ResourcesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源服务
 * @date 2019/3/6
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourcesService {

    @Resource
    private ResourcesMapper resourcesMapper;

    @Autowired
    private RoleService roleService;

    @Resource
    private RoleResourceMapper roleResourceMapper;

    @Resource
    private ResoucesBusinessMapper resoucesBusinessMapper;

    public void addResource(Resources resources) {
        resourcesMapper.insertSelective(resources);
    }

    /**
     * 批量插入资源
     *
     * @param resourcesDos
     */
    public void batchAddResource(List<ResourcesDto> resourcesDos) {
        if (CollUtil.isEmpty(resourcesDos)) {
            return;
        }
        List<Resources> insert = new ArrayList<>(resourcesDos.size());
        for (ResourcesDto resourcesDto : resourcesDos) {
            List<String> methods = resourcesDto.getMethod();
            String url = resourcesDto.getUrl();
            String description = resourcesDto.getDescription();
            String name = resourcesDto.getName();
            Byte permissionall = resourcesDto.getPermissionall();
            Byte use = resourcesDto.getUse();

            for (String method : methods) {
                Resources resources = new Resources();
                resources.setMethod(method);
                resources.setUrl(url);
                resources.setPermissionall(permissionall);
                resources.setUse(use);
                resources.setName(name);
                resources.setDescription(description);

                insert.add(resources);
            }
        }
        if (CollUtil.isEmpty(insert)) {
            return;
        }
        resoucesBusinessMapper.batchInsertResources(insert);
    }


    public boolean deleteResourceById(Integer resourcesId) {
        int i = resourcesMapper.deleteByPrimaryKey(resourcesId);
        return i == 1;
    }

    public boolean updateResourceById(Resources resources) {
        int i = resourcesMapper.updateByPrimaryKey(resources);
        return i == 0;
    }

    public Resources findResourceById(Integer resourcesId) {
        return (Resources) resourcesMapper.selectByPrimaryKey(resourcesId);
    }

    public Resources findResourcesByName(String name) {
        ResourcesExample resourcesExample = new ResourcesExample();
        resourcesExample.createCriteria().andNameEqualTo(name);
        List<Resources> resources = resourcesMapper.selectByExample(resourcesExample);
        if (resources.size() == 1) {
            return resources.get(0);
        }
        return null;
    }

    public List<Resources> findResourcesByLikeName(String likeName) {
        ResourcesExample resourcesExample = new ResourcesExample();
        resourcesExample.createCriteria().andNameLike(likeName);
        return resourcesMapper.selectByExample(resourcesExample);
    }

    public PageVo findResourcesPage(String key,
                                    Integer page,
                                    Integer limit) {
        List<Resources> resoucesPage
                = resoucesBusinessMapper.findResourcesPage(key, SQLUtil.getOffset(page, limit), limit);
        Integer integer = resoucesBusinessMapper.countResources(key, SQLUtil.getOffset(page, limit), limit);

        return PageVo.<Resources>builder()
                .data(resoucesPage)
                .total(new Long(integer))
                .page(page)
                .limit(limit)
                .build();
    }


    /**
     * 查询一个用户的所有权限信息
     *
     * @param account 账户名字（手机、邮箱、账户）
     * @return 权限集合
     */
    public List<Resources> findResourcesByAccount(String account) {
        List<Role> rolesByAccount = roleService.findRolesByAccount(account);
        if (rolesByAccount.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> ids = new ArrayList<>(rolesByAccount.size());
        rolesByAccount.forEach(role -> ids.add(role.getId()));

        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andRoleidIn(ids);
        List<RoleResource> roleResources = roleResourceMapper.selectByExample(example);
        if (roleResources.size() == 0) {
            log.info("用户{}没有资源", account);
            return new ArrayList<>();
        }
        List<Resources> resources = new ArrayList<>(roleResources.size());
        roleResources.forEach(roleResource -> {
            Integer resourceid = roleResource.getResourceid();
            resources.add((Resources) resourcesMapper.selectByPrimaryKey(resourceid));
        });
        log.info("用户{}拥有的资源为：{}", account, JSONUtil.toJsonStr(resources));
        return resources;
    }

    public List<Resources> findPermissionAllResources() {
        ResourcesExample example = new ResourcesExample();
        example.createCriteria().andPermissionallEqualTo((byte) 1);
        return resourcesMapper.selectByExample(example);
    }
}
