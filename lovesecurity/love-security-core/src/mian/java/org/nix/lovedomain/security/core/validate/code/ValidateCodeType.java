package org.nix.lovedomain.security.core.validate.code;


import org.nix.lovedomain.security.core.properties.SecurityConstants;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码类型信息
 * @date 2019/1/27
 */
public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * @return java.lang.String
     * @description 校验时从请求中获取的参数的名字
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    public abstract String getParamNameOnValidate();

}
