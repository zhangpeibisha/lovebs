package org.nix.zpbs.service;

import org.nix.zpbs.dto.response.UserResponseDetailDTO;

/**
 * 针对于用户信息的一些业务操作
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
public interface UserService {
    
    /**
     * 通过用户账户信息查到用户详细信息
     * @param account 账户包括（用户名、用户邮箱、用户手机号）
     * @return 用户信息
     */
    UserResponseDetailDTO getUserByAccount(String account);

}
