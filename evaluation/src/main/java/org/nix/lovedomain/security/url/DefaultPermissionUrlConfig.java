package org.nix.lovedomain.security.url;

import org.nix.lovedomain.databases.rbac.Resources;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 默认不需要访问的url
 * @date 2019/3/14
 */
@Component
public class DefaultPermissionUrlConfig implements PermissionUrlConfig {

    @Override
    public void config(List<Resources> urls) {
        Resources resources = new Resources();
        resources.setUrl("/login/**");
        resources.setMethod("get");
        urls.add(resources);
    }
}
