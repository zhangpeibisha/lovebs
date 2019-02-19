package org.nix.lovedomain.rbac.service.interfaces;

import org.nix.lovedomain.rbac.bean.po.User;
import org.nix.lovedomain.rbac.bean.po.UserRole;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户服务
 * @date 2019/2/18
 */
public interface UserService {

    Integer add(User user);

    Integer delete(Integer userId);

    Integer update(User user);

    List<User> listUser(User user);

    User selectByPrimaryKey(Integer userId);

    List<UserRole> listUserRoles(UserRole userRole);
}
