package org.nix.zpbs.utils.verification;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * 抽象验证码的共同特点
 * 使用注意：
 * 1. 子类命名： XXXConfirmationCode
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
public abstract class AbstractConfirmationCode<T extends ValidateCode> implements ConfirmationCode {
    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 从spring容器中获取这个类别的注入的所有bean
     */
    @Resource
    private Map<String, Generate> generates;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        T generate = generate();
        save(request, generate);
        send(request, generate);
    }

    /**
     * 发送校验码，方式由子类决定
     *
     * @param request  请求对象
     * @param generate 发送对象
     * @throws Exception 发送的时候发生了异常
     */
    protected abstract void send(ServletWebRequest request, T generate) throws Exception;

    /**
     * 将验证码对象保存到session中
     *
     * @param request  请求对象
     * @param generate 保存对象
     */
    private void save(ServletWebRequest request, T generate) {
        sessionStrategy.setAttribute(request, getSessionKey(), generate);
    }

    private String getSessionKey() {
        return SESSION_KEY_PREFIX + getValidateCodeType().toString().toUpperCase();
    }

    @Override
    public void check(ServletWebRequest request) {
        ValidateCodeType processorType = getValidateCodeType();
        String sessionKey = getSessionKey();

        T codeInSession = (T) sessionStrategy.getAttribute(request, sessionKey);

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
                    processorType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(processorType + "验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException(processorType + "验证码不存在");
        }

        if (codeInSession.isExpired()) {
            sessionStrategy.removeAttribute(request, sessionKey);
            throw new ValidateCodeException(processorType + "验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException(processorType + "验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, sessionKey);
    }

    /**
     * 获取验证码请求类型
     *
     * @return 返回验证码类型
     */
    private ValidateCodeType getValidateCodeType() {
        String classSuffix = "ConfirmationCode";
        String type = StringUtils.substringBefore(getClass().getSimpleName(), classSuffix);
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    private T generate() {
        // 获取验证码类别名字，并将值变为小写
        String type = getValidateCodeType().toString().toLowerCase();
        // 获取bean的名字
        String generatorName = type + Generate.class.getSimpleName();
        // 查询这个bean是否存在
        Generate generate = generates.get(generatorName);
        if (generate == null) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (T) generate.generate();
    }
}
