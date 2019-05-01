package org.nix.lovedomain.security.core.validate.code.impl;

import org.apache.commons.lang.StringUtils;
import org.nix.lovedomain.security.core.validate.code.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @description 抽象的验证码处理器
 * @date 2019/1/27
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode>
        implements ValidateCodeProcessor {


    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    /**
     * 在特定的环境实现该接口
     *
     * @see ValidateCodeRepository
     */
    @Autowired
    private ValidateCodeRepository validateCodeRepository;

    /**
     * @param request 用户请求
     * @return void
     * @description 验证码创建三部曲，1：生成 2：保存到session 3：发送给用户
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate();
        save(request, validateCode);
        send(request, validateCode);
    }

    /**
     * @return C
     * @description 生成验证码
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    protected C generate() {
        String type = getValidateCodeType().toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (C) validateCodeGenerator.generator();
    }

    /**
     * @return org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     * @description 处理方法，通过截取类的字符串名字获取到指定的类处理器。
     * 如果ImageCodeProcessor = image + CodeProcessor组成
     * 获取到注入的bean，因此这里主要是为了获取具体是哪个处理器在执行从而获取到验证码类型
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    private ValidateCodeType getValidateCodeType() {
        String type = StringUtils.substringBefore(getClass().getSimpleName(),
                "CodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    /**
     * @param request      用户请求
     * @param validateCode 验证码信息
     * @return void
     * @description 验证码发送方式由用户决定
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws IOException, Exception;

    /**
     * @param request      用户请求信息
     * @param validateCode 验证码信息
     * @return void
     * @description 将验证码信息放入session
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    protected void save(ServletWebRequest request, C validateCode) {
        validateCodeRepository.save(request, validateCode, getValidateCodeType());
    }


    /**
     * @return void
     * @description 验证用户输入的验证码是否正确，如果正确则通过，并删除验证码信息
     * 如果过期则删除验证码抛出异常让用户再次申请新的验证码，其他的则都是校验不通过
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    public void validate(ServletWebRequest request) {

//        ValidateCodeType processorType = getValidateCodeType();
//
//        ValidateCode codeInSession = validateCodeRepository.get(request, getValidateCodeType());
//
//        String codeInRequest;
//        try {
//            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
//                    processorType.getParamNameOnValidate());
//        } catch (ServletRequestBindingException e) {
//            throw new ValidateCodeException("获取验证码的值失败");
//        }
//
//        if (StringUtils.isBlank(codeInRequest)) {
//            throw new ValidateCodeException(processorType + "验证码的值不能为空");
//        }
//
//        if (codeInSession == null) {
//            throw new ValidateCodeException(processorType + "验证码不存在");
//        }
//
//        if (codeInSession.isExpired()) {
//            validateCodeRepository.remove(request, getValidateCodeType());
//            throw new ValidateCodeException(processorType + "验证码已过期");
//        }
//
//        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
//            throw new ValidateCodeException(processorType + "验证码不匹配");
//        }
//        validateCodeRepository.remove(request, processorType);
    }
}
