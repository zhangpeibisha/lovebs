package org.nix.lovedomain.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @author zhangpei
 * @version 1.0
 * @description 社交登陆成功处理器
 * @date 2019/2/3
 */
public interface SocialAuthenticationFilterPostProcessor {

    /**
     * @param socialAuthenticationFilter
     * @return void
     * @description 传入社交权限过滤器后进行自定义处理
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
