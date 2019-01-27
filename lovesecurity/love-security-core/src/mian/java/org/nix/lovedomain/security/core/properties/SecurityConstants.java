package org.nix.lovedomain.security.core.properties;

/**
 * @author zhangpei
 * @version 1.0
 * @description 系统常量信息
 * @date 2019/1/27
 */
public interface SecurityConstants {
    /**
     * 校验时从请求中获取的参数的名字
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "sms";
    /**
     * 校验时从请求中获取的参数的名字
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "image";
    /**
     * 请求验证码生成的路径前缀
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeController
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "validate";
}
