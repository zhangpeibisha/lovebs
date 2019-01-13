package org.nix.zpbs.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户组持久层
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/12
 */
@Repository
public interface UserGroupDao {

    /**
     * @param groupId 用户组id
     * @return 用户组的拥有的资源名字
     * @author zhangpe0312@qq.com
     * @description 通过用户组的id获取资源名字
     * @date 23:49 2019/1/12
     */
    List<String> getResourcesNameByUserGroupId(Long groupId);

}
