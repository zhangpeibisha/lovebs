package org.nix.lovedomain.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/3/7
 */
@Data
public class UrlGrantedAuthority implements GrantedAuthority {

    private final String httpMethod;

    private final String url;

    public UrlGrantedAuthority(String httpMethod, String url) {
        this.httpMethod = httpMethod;
        this.url = url;
    }

    @Override
    public String getAuthority() {
        return url;
    }
}
