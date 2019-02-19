package org.nix.lovedomain.rbac.service.impl;

import org.nix.lovedomain.rbac.bean.po.User;
import org.nix.lovedomain.rbac.bean.po.UserRole;
import org.nix.lovedomain.rbac.dao.UserMapper;
import org.nix.lovedomain.rbac.dao.UserRoleMapper;
import org.nix.lovedomain.rbac.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-08 17:00
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private
    UserMapper userMapper;

    @Autowired
    private
    UserRoleMapper userRoleMapper;


    @Transactional
    @Override
    public Integer add(User user) {
        Integer result = userMapper.insertSelective(user);
        System.out.println("result============" + result);
        insertUser(user);
        return result;
    }

    @Override
    public Integer delete(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer update(User user) {
        Integer result = userMapper.updateByPrimaryKeySelective(user);
        userRoleMapper.deleteByUserId(user.getUserId());
        insertUser(user);
        return result;
    }

    private void insertUser(User user) {
        if (user.getUserRoles() != null) {
            String[] strs = user.getUserRoles().split(",");
            List<UserRole> userRoles = new ArrayList<>();
            UserRole userRole = null;
            for (String str : strs) {
                userRole = new UserRole();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(Integer.parseInt(str));
                userRoles.add(userRole);
            }
            Integer i = userRoleMapper.batchInsert(userRoles);
            System.out.println("i=========" + i);
        }
    }

    @Override
    public List<User> listUser(User user) {
        return userMapper.listUser(user);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserRole> listUserRoles(UserRole userRole) {
        return userRoleMapper.listUserRoles(userRole);
    }

}
