package org.nix.zhangpei.account.dao;

import com.alibaba.fastjson.JSON;
import org.nix.zhangpei.account.model.LoginPO;
import org.springframework.stereotype.Repository;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
@Repository
public interface LoginMapper {
    /**
     * 通过账户名找到登陆信息
     *
     * @param accountName 账户信息
     * @return 账户详细信息
     */
    LoginPO findLoginByAccountName(String accountName);

    /**
     * 通过手机号码找到用户信息
     *
     * @param phone 手机号码
     * @return 账户详细信息
     */
    LoginPO findLoginByPhone(String phone);

    /**
     * 通过邮箱号码找到用户信息
     *
     * @param email 邮箱号码
     * @return 账户详细信息
     */
    LoginPO findLoginByEmail(String email);
}
