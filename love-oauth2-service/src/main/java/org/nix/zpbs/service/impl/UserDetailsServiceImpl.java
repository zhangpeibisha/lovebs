package org.nix.zpbs.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.nix.zpbs.model.User user = service.getUserByAccount(username);
        log.info("查询用户信息为：{}",JSONUtil.toJsonPrettyStr(user));
        if (user == null){
            log.debug("{}用户没有在册信息",username);
            throw new UsernameNotFoundException("无效的用户名或者密码");
        }
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        List<String> resourcesByUserGroupId = service.getPowersByUserId(user.getId());
        resourcesByUserGroupId.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
                simpleGrantedAuthorities.add(simpleGrantedAuthority);
            }
        });
        log.info("用户权限信息为：{}",JSONUtil.toJsonPrettyStr(resourcesByUserGroupId));
        return new User(user.getUserName(),user.getUserPwd(),simpleGrantedAuthorities);
    }
}
