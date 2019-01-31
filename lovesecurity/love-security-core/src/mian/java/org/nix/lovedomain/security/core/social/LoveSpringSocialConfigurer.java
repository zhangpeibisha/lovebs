package org.nix.lovedomain.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方应用配置
 * @date 2019/1/31
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
