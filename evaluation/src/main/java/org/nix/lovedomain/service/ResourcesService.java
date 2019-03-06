package org.nix.lovedomain.service;

import org.nix.lovedomain.databases.mapper.ResourcesMapper;
import org.nix.lovedomain.databases.model.Resources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源服务
 * @date 2019/3/6
 */
@Service
public class ResourcesService {

    @Resource
    private ResourcesMapper resourcesMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addResource(Resources resources) {
        resourcesMapper.insertSelective(resources);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteResourceById(Integer resourcesId) {
        int i = resourcesMapper.deleteByPrimaryKey(resourcesId);
        return i == 1;
    }

    public boolean updateResourceById(Resources resources){
        int i = resourcesMapper.updateByPrimaryKey(resources);
        return i == 0;
    }
}
