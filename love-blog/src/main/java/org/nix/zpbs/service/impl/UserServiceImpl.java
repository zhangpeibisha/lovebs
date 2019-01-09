package org.nix.zpbs.service.impl;

import org.nix.zpbs.dao.UserDao;
import org.nix.zpbs.dto.response.UserResponseDetailDTO;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.model.User;
import org.nix.zpbs.model.UserExample;
import org.nix.zpbs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/10
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserResponseDetailDTO getUserByAccount(String account) {
        UserExample example = new UserExample();

        example.or().andUserNameEqualTo(account);
        try {
            // 如果抛异常则不会加入条件判断
            long value = Long.parseLong(account);
            example.or().andUserPhoneEqualTo(value);
        } catch (NumberFormatException e) {
            // 不是数字抛异常，忽略处理
        }
        example.or().andUserEmailEqualTo(account);
        List<User> users = userMapper.selectByExample(example);
        return null;
    }
}
