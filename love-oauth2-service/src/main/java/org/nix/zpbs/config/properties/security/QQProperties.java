package org.nix.zpbs.config.properties.security;
import lombok.Data;
import org.nix.zpbs.utils.social.SocialConfig;
import org.nix.zpbs.utils.social.base.SocialProperties;
/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/21
 */
@Data
public class QQProperties extends SocialProperties{
    private String providerId = "qq";
    /**
     * qq用户信息表的前缀
     * @see SocialConfig
     */
    private String qqTablePrefix = "";
}
