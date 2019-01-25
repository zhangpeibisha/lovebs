package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/25
 */
@Data
public class LogoutProperties {

    private String logoutUrl = "/love/logout";

    private String logoutSuccessUrl = "/login/logout.html";

}
