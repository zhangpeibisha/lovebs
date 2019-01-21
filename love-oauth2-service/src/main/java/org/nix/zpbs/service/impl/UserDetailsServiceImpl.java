package org.nix.zpbs.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 学习使用 ：https://www.cnblogs.com/cjsblog/p/9152455.html
 * 用户授权认证服务，继承与
 * @see UserDetailsService
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService,SocialUserDetailsService {

    @Resource
    private UserService service;

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.nix.zpbs.model.User user = service.getUserByAccount(username);
        if (user == null){
            log.debug("{}用户没有在册信息",username);
            throw new UsernameNotFoundException("无效的用户名或者密码");
        }
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = getAuthorities(user.getId());
        log.info("用户权限信息为：{}",JSONUtil.toJsonPrettyStr(simpleGrantedAuthorities));
        return new User(user.getUserName(),user.getUserPwd(),simpleGrantedAuthorities);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        org.nix.zpbs.model.User user = userMapper.selectByPrimaryKey(Long.parseLong(userId));
        ArrayList<SimpleGrantedAuthority> authorities = getAuthorities(Long.parseLong(userId));
        log.info("社交用户权限信息为：{}",JSONUtil.toJsonPrettyStr(authorities));
        return new SocialUser(user.getUserName(),user.getUserPwd(), authorities);
    }

    private ArrayList<SimpleGrantedAuthority> getAuthorities(Long userId){
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        List<String> resourcesByUserGroupId = service.getPowersByUserId(userId);
        resourcesByUserGroupId.forEach(s -> {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
            simpleGrantedAuthorities.add(simpleGrantedAuthority);
        });
        return simpleGrantedAuthorities;
    }
}
