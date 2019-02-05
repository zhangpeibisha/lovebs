package org.nix.love.sso.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author zhangpei
 * @version 1.0
 * @description sso用户服务，用于返回用户信息
 * @date 2019/2/5
 */
@Component
public class UserDeatilServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        // 设置用户权限
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(username, passwordEncoder.encode("123456"), authorities);
    }
}
