package org.nix.lovedomain.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Set<ConfigAttribute> allAttributes = new HashSet<>();
        ConfigAttribute configAttribute = new UrlConfigAttribute(request);
        allAttributes.add(configAttribute);
        return allAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}
