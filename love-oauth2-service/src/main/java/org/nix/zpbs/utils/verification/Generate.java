package org.nix.zpbs.utils.verification;

/**
 * 验证码生成器
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
public interface Generate {

    /**
     * 生成一个验证码对象
     * @return 生成一个验证码
     */
    ValidateCode generate();

}
