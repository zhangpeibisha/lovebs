package org.nix.lovedomain.security.browser.validate.code.impl;

import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCode;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeRepository;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description redis存储验证码信息
 * @date 2019/2/3
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 验证码放入session时的前缀
     */
    private static final String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * @param request      用户请求
     * @param validateCode 验证码
     * @param codeType     验证码类型
     * @return void
     * @description 保存验证码信息，设置过期时间配置 securityProperties.getRedisExpired() 单位秒
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @Override
    public void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeType codeType) {
        sessionStrategy.setAttribute(request, getSessionKey(codeType), validateCode);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType codeType) {
        return (ValidateCode) sessionStrategy.getAttribute(request,getSessionKey(codeType));
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        sessionStrategy.removeAttribute(request, getSessionKey(codeType));
    }

    /**
     * @return java.lang.String
     * @description 获取到保存在session中的key, 因为需要使用该方法从session取出值来校验和使用该
     * 值将验证码信息注入到session中
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    private String getSessionKey(ValidateCodeType codeType) {
        return SESSION_KEY_PREFIX + codeType.toString().toUpperCase();
    }


}
