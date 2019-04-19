package org.nix.lovedomain.security.app.social.openid;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author zhangpei
 * @version 1.0
 * @description OpenIdAuthenticationToken封装请求信息Token
 * @date 2019/2/3
 */
public class OpenIdAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    private String providerId;

    public OpenIdAuthenticationToken(Object principal, String providerId) {
        super(null);
        this.principal = principal;
        this.providerId = providerId;
        setAuthenticated(false);
    }

    /**
     * This constructor should only be used by <code>AuthenticationManager</code> or
     * <code>AuthenticationProvider</code> implementations that are satisfied with
     * producing a trusted (i.e. {@link #isAuthenticated()} = <code>true</code>)
     * authentication token.
     *
     * @param principal openid
     * @param authorities 权限信息
     */
    public OpenIdAuthenticationToken(Object principal,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        // must use super, as we override
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public String getProviderId() {
        return providerId;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
