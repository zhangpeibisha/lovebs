package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.AccountModel;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/23
 */
public interface AccountBusinessMapper extends BaseBusinessMapper<AccountModel> {

    /**
     * 通过登陆名查询用户账号
     *
     * @param loginName 登陆名（账号、电话、邮箱）
     * @return 用户账号
     */
    @Select(value = "SELECT * FROM `account` WHERE numbering = #{loginName} OR phone = #{loginName} OR email = #{loginName};")
    AccountModel findAccountByNumberOrPhoneOrEmail(@Param(value = "loginName") String loginName);

}
