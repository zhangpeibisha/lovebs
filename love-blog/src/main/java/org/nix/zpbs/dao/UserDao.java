package org.nix.zpbs.dao;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/8
 */
public interface UserDao {
    /**
     * 检测账户的账号和密码是否正确
     * @param account
     * @param password
     * @return
     */
    Boolean checkAccountAndPassword(String account,String password);

}
