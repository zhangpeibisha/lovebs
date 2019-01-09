package org.nix.zpbs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.dto.response.UserResponseDetailDTO;
import org.nix.zpbs.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

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
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponseDetailDTO userByAccount = service.getUserByAccount(username);
        log.debug("{}用户不存在",userByAccount);
        if (userByAccount == null){
            throw new UsernameNotFoundException("无效的用户名或者密码");
        }
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        String userPower = userByAccount.getUserPower();
        return null;
    }
}
