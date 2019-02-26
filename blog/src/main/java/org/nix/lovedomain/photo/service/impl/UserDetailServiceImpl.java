package org.nix.lovedomain.photo.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.mapper.UserMapper;
import org.nix.lovedomain.photo.model.User;
import org.nix.lovedomain.photo.model.UserExample;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description security验证用户信息
 * @date 2019/2/25
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService,SocialUserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("表单登陆{}",userName);
        return findUserDetails(userName);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userName) throws UsernameNotFoundException {
        log.info("社交登陆{}",userName);
        return findUserDetails(userName);
    }

    private SocialUserDetails findUserDetails(String userName){
        UserExample example = new UserExample();
        UserExample.Criteria userNameCriteria = example.createCriteria();
        userNameCriteria.andUsernameEqualTo(userName);
        UserExample.Criteria phoneCriteria = example.createCriteria();
        phoneCriteria.andPhoneEqualTo(userName);
        example.or(userNameCriteria);
        example.or(phoneCriteria);
        List<User> users = userMapper.selectByExample(example);
        log.info("查询到的用户信息为信息为{}",JSONUtil.toJsonStr(users));
        if (users.size() == 1){
            User user = users.get(0);
            String password = user.getPassword();
            password = passwordEncoder.encode(password);
            return new SocialUser(userName, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        }else {
            throw new UsernameNotFoundException("账户或者密码错误");
        }
    }

}
