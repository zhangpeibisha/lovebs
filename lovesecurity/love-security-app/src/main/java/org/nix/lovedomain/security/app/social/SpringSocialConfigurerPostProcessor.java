package org.nix.lovedomain.security.app.social;

import org.apache.commons.lang.StringUtils;
import org.nix.lovedomain.security.core.social.LoveSpringSocialConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description  Bean
 *  初始化之前和初始化后都要经过这个
 *  需要用户注册时不要跳转到之前浏览器情况下注册页面
 *  这里配置是将跳转到/social/signUp的服务上面
 * @date 2019/2/3
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 如果是这个bean 做指定的处理 ===> 指定注册路径
        String loveSocialSecurityConfig = "loveSocialSecurityConfig";
        if (StringUtils.equals(beanName, loveSocialSecurityConfig)) {
            LoveSpringSocialConfigurer configurer = (LoveSpringSocialConfigurer)bean;
            configurer.signupUrl("/social/signUp");
            return configurer;
        }
        return bean;
    }

}
