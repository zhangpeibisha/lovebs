package org.nix.zpbs.config;


import org.nix.zpbs.utils.verification.Generate;
import org.nix.zpbs.utils.verification.image.ImageGenerate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Configuration
public class VerificationConfig {
    /**
     * 配置图生成器
     * @return 图片生成器
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageGenerate")
    public Generate imageGenerate() {
        return new ImageGenerate();
    }
}
