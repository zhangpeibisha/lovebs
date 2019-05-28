package org.nix.lovedomain.security.core.validate.code;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码信息生成接口
 * @date 2019/1/27
 */
public interface ValidateCodeGenerator {

    /**
     * 验证码生成
     *
     * @return ValidateCode
     * @description 验证码生成
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    ValidateCode generator();

}
