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

    private ValidateCodeProperties validate = new ValidateCodeProperties();

}
