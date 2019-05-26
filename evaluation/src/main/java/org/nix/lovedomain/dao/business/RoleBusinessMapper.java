package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.RoleModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
public interface RoleBusinessMapper extends BaseBusinessMapper<RoleModel> {

    /**
     * 通过登陆名发现用户的角色信息
     * @param loginName 登陆名字
     * @return 角色信息
     */
    @Select(value = "SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\trole AS r\n" +
            "LEFT JOIN account_role AS ar ON r.id=ar.roleId\n" +
            "LEFT JOIN account AS a ON ar.accountId = a.id\n" +
            "WHERE a.email = #{loginName} OR a.phone = #{loginName} OR a.numbering = #{loginName}")
    List<RoleModel> findRoleModelsByLoginName(String loginName);

}
