package org.nix.zpbs.config.properties.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全配置总类
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/16
 */
@ConfigurationProperties(prefix = "love.security")
@Data
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties validate = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();

}
