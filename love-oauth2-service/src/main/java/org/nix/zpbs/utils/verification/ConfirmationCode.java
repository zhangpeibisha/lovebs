package org.nix.zpbs.utils.verification;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 确认码接口，用于统一确认码的管理
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
public interface ConfirmationCode{
    /**
     * session中的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_COE_";

    /**
     * 用户创建、保存、发送的接口
     * @param request 用户请求对象
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验用户输入和申请的值是否相同
     * @param request 用户请求对象
     */
    void check(ServletWebRequest request);

}
