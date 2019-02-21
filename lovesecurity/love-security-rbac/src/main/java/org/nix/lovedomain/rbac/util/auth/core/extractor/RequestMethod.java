package org.nix.lovedomain.rbac.util.auth.core.extractor;

/**
 * @author zhangpei
 * @version 1.0
 * @description 请求方法
 * @date 2019/2/17
 */
public enum RequestMethod {
    /**
     * http请求方法
     */
    GET,
    HEAD,
    POST,
    PUT,
    PATCH,
    DELETE,
    OPTIONS,
    TRACE;

    private RequestMethod() {
    }
}
