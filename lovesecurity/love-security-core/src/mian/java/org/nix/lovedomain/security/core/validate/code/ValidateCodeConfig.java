package org.nix.lovedomain.security.core.validate.code;

import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.validate.code.image.ImageValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码配置类
 * @date 2019/1/27
 */
@Configuration
public class ValidateCodeConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @return org.nix.lovedomain.security.core.validate.code.image.ImageValidateCodeGenerator
     * @description 将图片生成器注入到spring容器中，如果用户重新注入了这个类则该配置失效
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Bean("imageValidateCodeGenerator")
    @ConditionalOnMissingBean(ImageValidateCodeGenerator.class)
    public ImageValidateCodeGenerator imageValidateCodeGenerator() {
        ImageValidateCodeGenerator imageValidateCodeGenerator = new ImageValidateCodeGenerator();
        imageValidateCodeGenerator.setImageProperties(securityProperties.getValidate().getImage());
        return imageValidateCodeGenerator;
    }

}
