package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.AccountModel;

import java.util.List;

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

    /**
     * 通过 id的范围查询账号id（测试是使用）
     * @param start
     * @param end
     * @return
     */
    @Select(value = "SELECT\n" +
            "\tid\n" +
            "FROM\n" +
            "\taccount\n" +
            "WHERE\n" +
            "\tid <= #{end}\n" +
            "AND id > #{start}")
    List<Integer> findAccountIdByIdRange(@Param(value = "start") Integer start,
                                         @Param(value = "end")Integer end);

}
