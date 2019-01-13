package org.nix.zpbs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.dao.UserGroupDao;
import org.nix.zpbs.service.UserGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户组服务
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/12
 */
@Slf4j
@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Resource
    private UserGroupDao userGroupDao;

    /**
     * @param groupId 用户组id
     * @return 返回该用户组拥有的所有资源的名字
     * @author zhangpe0312@qq.com
     * @description 通过用户组id得到用户组拥有的资源
     * @date 23:20 2019/1/12
     */
    @Override
    public List<String> getResourcesByUserGroupId(Long groupId) {
        return userGroupDao.getResourcesNameByUserGroupId(groupId);
    }
}
