package org.nix.zpbs.utils.verification;

/**
 * 设置请求验证的类别
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
public enum ValidateCodeType {
    /**
     * 图片类别
     */
    IMAGE{
        @Override
        public String getParamNameOnValidate() {
            return "image";
        }
    },
    /**
     * 手机短信类别
     */
    SMS{
        @Override
        public String getParamNameOnValidate() {
            return "sms";
        }
    };

    public abstract String getParamNameOnValidate();
}
