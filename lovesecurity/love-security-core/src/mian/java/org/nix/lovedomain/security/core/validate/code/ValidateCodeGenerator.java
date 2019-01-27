package org.nix.lovedomain.security.core.validate.code;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码信息生成接口
 * @date 2019/1/27
 */
public interface ValidateCodeGenerator {

    /**
     * @return org.nix.lovedomain.security.core.validate.code.ValidateCode
     * @description 功能描述
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    ValidateCode generator();

}
