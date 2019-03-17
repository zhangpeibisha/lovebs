package org.nix.lovedomain.security;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.databases.rbac.Account;
import org.nix.lovedomain.databases.rbac.Resources;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description security框架验证用户信息的地方
 * @date 2019/3/5
 */
@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户{}表单登陆", username);
        return builderUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException {
        return builderUser(username);
    }

    private SocialUserDetails builderUser(String username) {
        Account userByAccount = accountService.findUserByAccount(username);
        // 测试的时候不加密,使用默认加密方式
        userByAccount.setPassword(passwordEncoder.encode(userByAccount.getPassword()));
        List<Resources> resourcesByAccount = resourcesService.findResourcesByAccount(username);
        return new AuthenUserDetail(userByAccount, resourcesByAccount, username);
    }

}
