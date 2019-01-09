package org.nix.zpbs.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/8
 */

public interface UserDao {
    /**
     * 检测账户的账号和密码是否正确
     * @param account 账户信息
     * @param password 用户密码
     * @return 查询到有多少个匹配信息
     */
    int checkAccountAndPassword(String account,String password);

}
