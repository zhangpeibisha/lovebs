package org.nix.zpbs.service.impl;

import org.nix.zpbs.pojo.dto.response.UserResponseDetailDTO;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.model.User;
import org.nix.zpbs.model.UserExample;
import org.nix.zpbs.service.UserService;
import org.nix.zpbs.utils.PojoadAptationUtil;
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


    /**
     * @param account 账户包括（用户名、用户邮箱、用户手机号）
     * @return 用户的详细信息
     */
    @Override
    public UserResponseDetailDTO getUserByAccount(String account) {
        if (account == null){
            throw new ServiceException("无效的用户名或者密码");
        }
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
        if (users == null || users.size() != 1) {
            throw new ServiceException("无效的用户名或者密码");
        }
        User user = users.get(0);
        return PojoadAptationUtil.convertPojo(user, UserResponseDetailDTO.class);
    }

    /**
     * TODO 通过用户id获取用户所有的权限id
     * @param userId 用户id
     * @return 用户权限id集合
     */
    @Override
    public List<Long> getPowersByUserId(Long userId) {
       return null;
    }
}
