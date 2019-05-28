/**
 *
 */
package org.nix.lovedomain.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zhangpei
 * @version 1.0
 * @description QQ登陆的配置信息
 * @date 2019/1/31
 */
@Data
public class QQProperties extends SocialProperties {

    /**
     * qq服务标识
     */
    private String providerId = "qq";


}
