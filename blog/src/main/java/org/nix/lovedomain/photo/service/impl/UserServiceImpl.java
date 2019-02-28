package org.nix.lovedomain.photo.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.mapper.UserMapper;
import org.nix.lovedomain.photo.model.User;
import org.nix.lovedomain.photo.model.UserExample;
import org.nix.lovedomain.photo.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户服务实现
 * @date 2019/2/28
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserByAccount(String account) {
        UserExample example = new UserExample();
        UserExample.Criteria userNameCriteria = example.createCriteria();
        userNameCriteria.andUsernameEqualTo(account);
        UserExample.Criteria phoneCriteria = example.createCriteria();
        phoneCriteria.andPhoneEqualTo(account);
        example.or(userNameCriteria);
        example.or(phoneCriteria);
        List<User> users = userMapper.selectByExample(example);
        log.info("查询到的用户信息为信息为{}",JSONUtil.toJsonStr(users));
        if (users.size() == 1){
            return users.get(0);
        }else {
            throw new UsernameNotFoundException("账户或者密码错误");
        }
    }
}
