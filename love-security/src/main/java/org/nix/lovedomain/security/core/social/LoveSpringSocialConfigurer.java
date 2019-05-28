package org.nix.lovedomain.security.core.social;

import lombok.Getter;
import lombok.Setter;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方应用配置
 * @date 2019/1/31
 */
@Setter
@Getter
public class LoveSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

    public LoveSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    /**
     * @param object
     * @return T
     * @description 当第三方认证成功时的处理，如果注入了socialAuthenticationFilterPostProcessor接口的实现
     * 则使用，否则不使用
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        if (socialAuthenticationFilterPostProcessor != null) {
            socialAuthenticationFilterPostProcessor.process(filter);
        }
        return (T) filter;
    }
}
