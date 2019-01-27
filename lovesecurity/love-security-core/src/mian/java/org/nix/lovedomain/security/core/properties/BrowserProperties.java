package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器属性配置类
 * @date 2019/1/27
 */
@Data
public class BrowserProperties {

    private LoginResponseType loginType = LoginResponseType.JSON;

}
