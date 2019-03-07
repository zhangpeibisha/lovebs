package org.nix.lovedomain.security;

import lombok.Data;
import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

@Data
public class UrlConfigAttribute implements ConfigAttribute {

    private final HttpServletRequest httpServletRequest;

    public UrlConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public String getAttribute() {
        return null;
    }

}
