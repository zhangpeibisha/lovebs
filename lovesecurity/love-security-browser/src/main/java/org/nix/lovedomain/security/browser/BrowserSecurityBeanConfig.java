package org.nix.lovedomain.security.browser;

import org.nix.lovedomain.security.browser.session.LoveExpiredSessionStrategy;
import org.nix.lovedomain.security.browser.session.LoveInvalidSessionStrategy;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器安全配置
 * @date 2019/2/1
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @return org.springframework.security.web.session.InvalidSessionStrategy
     * @description session失效默认处理策略，如果用户自己实现了该策略则该配置失效
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new LoveInvalidSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    /**
     * @return org.springframework.security.web.session.SessionInformationExpiredStrategy
     * @description session过期处理，如果用户自己实现了该策略则该配置失效
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new LoveExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }
}
