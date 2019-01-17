package org.nix.zpbs.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.config.security.LoveAuthenticationFailHandler;
import org.nix.zpbs.utils.verification.ValidateCodeFilter;
import org.nix.zpbs.utils.verification.VerificationCode;
import org.nix.zpbs.utils.verification.image.ImageVerification;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Configuration
public class VerificationConfig {

    /**
     * 注入图片验证码
     * @return 图片验证码实体
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageVerification")
    public VerificationCode imageVerification(){
        return new ImageVerification();
    }
}
