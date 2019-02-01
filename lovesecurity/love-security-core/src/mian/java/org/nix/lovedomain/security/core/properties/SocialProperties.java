package org.nix.lovedomain.security.core.properties;

import lombok.Data;
import org.springframework.social.connect.web.ConnectController;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方应用配置信息
 * @date 2019/1/31
 */
@Data
public class SocialProperties {

    /**
     * 第三方登陆时的登陆前缀
     */
    private String filterProcessesUrl = "/auth";
    /**
     * 第三方绑定信息处理的url前缀
     * @see ConnectController 这个控制器中可以查看具体的信息
     */
    private String connect = "/connect";

    /**
     * QQ登陆的配置信息
     */
    private QQProperties qq = new QQProperties();

    /**
     * 微信登陆的配置信息
     */
    private WeixinProperties weixin = new WeixinProperties();
}
