package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.ResourcesModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源业务映射
 * @date 2019/4/24
 */
public interface ResourcesBusinessMapper extends BaseBusinessMapper<ResourcesModel> {

    /**
     * 通过关键字查询资源并分页
     *
     * @param key    关键字
     * @param offset 偏移量
     * @param limit  数量
     * @return
     */
    List<ResourcesModel> findResourcesPage(@Param(value = "key") String key,
                                           @Param(value = "offset") Integer offset,
                                           @Param(value = "limit") Integer limit);

    Integer countResources(@Param(value = "key") String key,
                           @Param(value = "offset") Integer offset,
                           @Param(value = "limit") Integer limit);

    /**
     * 通过登陆名查询到用户的所有可以访问的资源信息
     *
     * @param loginName 登陆名
     * @return
     */
    @Select(value = "SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tresources AS r\n" +
            "LEFT JOIN role_resource AS rr ON r.id = rr.resourceId\n" +
            "LEFT JOIN role ON rr.roleId = role.id\n" +
            "LEFT JOIN account_role AS ar ON ar.roleId = role.id\n" +
            "LEFT JOIN account AS a ON ar.accountId = a.id\n" +
            "WHERE a.email = #{loginName} OR a.phone = #{loginName} OR a.numbering = #{loginName}")
    List<ResourcesModel> findResourcesByLoginName(@Param(value = "loginName") String loginName);

}
