package org.nix.lovedomain.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/27
 */
@ConfigurationProperties(prefix = "love.security")
@Data
public class SecurityProperties {

    /**
     * 验证码使用配置信息
     */
    private ValidateCodeProperties validate = new ValidateCodeProperties();
    /**
     * 浏览器使用配置信息
     */
    private BrowserProperties browser = new BrowserProperties();
    /**
     * 第三方应用配置
     */
    private SocialProperties social = new SocialProperties();
    /**
     * redis过期时间，单位秒
     */
    private long redisExpired = 30;
    /**
     * oAuth2配置信息
     */
    private OAuth2Properties oAuth2 = new OAuth2Properties();
}
