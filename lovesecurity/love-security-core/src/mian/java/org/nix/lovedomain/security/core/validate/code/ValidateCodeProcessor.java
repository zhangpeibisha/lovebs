package org.nix.lovedomain.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description 校验码处理器，封装不同校验码的处理逻辑
 * @date 2019/1/27
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * @param request 用户请求参数
     * @return void
     * @throws Exception 如果创建失败则抛出异常
     * @description 创建校验码
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * @param servletWebRequest  用户请求参数
     * @return void
     * @description 校验验证码
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    void validate(ServletWebRequest servletWebRequest);

}
