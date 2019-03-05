package org.nix.lovedomain.security;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.databases.model.Account;
import org.nix.lovedomain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description security框架验证用户信息的地方
 * @date 2019/3/5
 */
@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService,SocialUserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户{}表单登陆",username);
        return builderUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException {
        return builderUser(username);
    }

    private SocialUser builderUser(String username){
        Account userByAccount = accountService.findUserByAccount(username);
        return new SocialUser(username,userByAccount.getPassword(),null);
    }

}
