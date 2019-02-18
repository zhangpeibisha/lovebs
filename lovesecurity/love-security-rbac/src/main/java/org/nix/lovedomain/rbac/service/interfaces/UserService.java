package org.nix.lovedomain.rbac.service.interfaces;

import org.nix.lovedomain.rbac.bean.po.User;
import org.nix.lovedomain.rbac.bean.po.UserRole;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-08 16:59
 */
public interface UserService {

    Integer add(User user);

    Integer delete(Integer userId);

    Integer update(User user);

    List<User> listUser(User user);

    User selectByPrimaryKey(Integer userId);

    List<UserRole> listUserRoles(UserRole userRole);

}
