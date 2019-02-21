package org.nix.lovedomain.rbac.util.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源配置信息
 * @date 2019/2/21
 */
@Data
@ConfigurationProperties(prefix = "permission.resources")
@Component
public class PermissionProperties {

    private Resources resources = new Resources();

    @Data
    static class Resources {
        String path = "";
    }

}
