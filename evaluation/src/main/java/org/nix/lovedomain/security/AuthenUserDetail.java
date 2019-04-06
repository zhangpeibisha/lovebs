package org.nix.lovedomain.security;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Resources;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
public class AuthenUserDetail implements SocialUserDetails {

    private Account account;

    private List<Resources> resources;

    private final List<UrlGrantedAuthority> grantedAuthorities;

    private String userName;

    public AuthenUserDetail(Account account, List<Resources> resources, String userName) {
        this.account = account;
        this.grantedAuthorities = resources.stream().map(it -> {
            String mehtod = it.getMethod();
            return new UrlGrantedAuthority(mehtod, it.getUrl());
        }).collect(Collectors.toList());
        log.info("用户{}的权限为：{}", userName, JSONUtil.toJsonStr(resources));
        this.resources = resources;
        this.userName = userName;
    }

    @Override
    public String getUserId() {
        return account.getId().toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account != null;
    }
}
