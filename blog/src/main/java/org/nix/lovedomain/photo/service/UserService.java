package org.nix.lovedomain.photo.service;

import org.nix.lovedomain.photo.model.User;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户服务
 * @date 2019/2/28
 */
public interface UserService {

    void register(User user);

    void update(User user);

    User selectUserByAccount(String account);
}
