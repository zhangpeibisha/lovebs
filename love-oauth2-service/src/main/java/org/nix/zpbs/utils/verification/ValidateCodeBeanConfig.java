package org.nix.zpbs.utils.verification;

import org.nix.zpbs.utils.verification.image.ImageGenerate;
import org.nix.zpbs.utils.verification.sms.DefaultSmsCodeSender;
import org.nix.zpbs.utils.verification.sms.SmsCodeSender;
import org.nix.zpbs.utils.verification.sms.SmsGenerate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码bean放在这里
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/25
 */
@Configuration
public class ValidateCodeBeanConfig {

    /**
     * 配置图生成器
     * @return 图片生成器
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageGenerate")
    public Generate imageGenerate() {
        return new ImageGenerate();
    }

    /**
     * 配置手机验证码生成器
     * @return 手机验证码生成器
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender defaultSmsGenerate() {
        return new DefaultSmsCodeSender();
    }

    /**
     * 配置手机验证码生成器
     * @return 手机验证码生成器
     */
    @Bean
    @ConditionalOnMissingBean(name = "smsGenerate")
    public Generate smsGenerate() {
        return new SmsGenerate();
    }

}
