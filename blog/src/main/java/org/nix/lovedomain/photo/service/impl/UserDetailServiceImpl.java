package org.nix.lovedomain.photo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.model.User;
import org.nix.lovedomain.photo.service.UserService;
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
    private UserService userService;

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
        User user = userService.selectUserByAccount(userName);
        String password = passwordEncoder.encode(user.getPassword());
        return new SocialUser(userName, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

}
