package org.nix.lovedomain.rbac.util.auth.core.extractor;

import lombok.Data;

import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源信息实体类
 * @date 2019/2/15
 */
@Data
public class Resources {

    /**
     * 资源请求方法
     */
    private Set<RequestMethod> httpMethods;
    /**
     * 资源url
     */
    private String url;
    /**
     * 资源名字
     */
    private String name;
    /**
     * 资源描述
     */
    private String description;
    /**
     * 资源是否开放
     */
    private Boolean open;

    /**
     * 是否允许未登录访问
     */
    private Boolean permitAll;
}
