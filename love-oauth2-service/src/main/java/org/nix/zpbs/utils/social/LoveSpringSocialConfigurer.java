package org.nix.zpbs.utils.social;

import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/22
 */
public class LoveSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public LoveSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }


}
