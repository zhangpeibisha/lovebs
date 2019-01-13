package org.nix.zpbs.service;

import org.nix.zpbs.model.User;
import org.nix.zpbs.pojo.dto.response.UserResponseDetailDTO;

import java.util.List;

/**
 * 针对于用户信息的一些业务操作
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
public interface UserService {

    /**
     * 通过用户账户信息查到用户详细信息
     *
     * @param account 账户包括（用户名、用户邮箱、用户手机号）
     * @return 用户信息
     */
    User getUserByAccount(String account);

    /**
     * @param account 账户包括（用户名、用户邮箱、用户手机号）
     * @return 返回用户的除开密码的信息
     * @author zhangpe0312@qq.com
     * @description 专门获取用户信息，除了用户密码
     * @date 0:24 2019/1/13
     */
    UserResponseDetailDTO getUserDetailDtoByAccount(String account);

    /**
     * 通过用户id获取到用户权限列表
     *
     * @param userId 用户id
     * @return 用户可访问资源id集合
     */
    List<String> getPowersByUserId(Long userId);

}
