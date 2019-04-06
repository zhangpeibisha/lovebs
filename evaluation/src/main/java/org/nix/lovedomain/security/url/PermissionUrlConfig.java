package org.nix.lovedomain.security.url;

import org.nix.lovedomain.model.Resources;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 免验证路径配置接口，只要实现该接口并注入到spring容器中就可以实现不用认证就可以访问
 * @date 2019/3/14
 */
public interface PermissionUrlConfig {
    /**
     * @param urls
     * @return void
     * @description 向urls中添加不需要验证就可以访问的url
     * @author zhangpe0312@qq.com
     * @date 2019/3/14
     */
    void config(List<Resources> urls);

}
