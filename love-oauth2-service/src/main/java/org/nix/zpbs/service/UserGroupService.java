package org.nix.zpbs.service;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/12
 */
public interface UserGroupService {

    /**
     * @param groupId 用户组id
     * @return 返回该用户组拥有的所有资源的名字
     * @author zhangpe0312@qq.com
     * @description 通过用户组id得到用户组拥有的资源
     * @date 23:20 2019/1/12
     */
    List<String> getResourcesByUserGroupId(Long groupId);

}
