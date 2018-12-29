package org.nix.zhangpei.love.recording.config;

import org.nix.zhangpei.love.recording.controller.controller.resolver.UserResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/29
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 注册Person的参数分解器
        argumentResolvers.add(new UserResolver());
    }
}
