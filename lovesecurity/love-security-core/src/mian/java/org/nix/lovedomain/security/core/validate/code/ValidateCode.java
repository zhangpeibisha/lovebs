package org.nix.lovedomain.security.core.validate.code;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码model基类
 * @date 2019/1/27
 */
@Data
public class ValidateCode {
    /**
     * 验证码字符串
     */
    private String code;
    /**
     * 验证码过期时间
     */
    private LocalDateTime expired;

    public ValidateCode(String code, Integer expired) {
        this.code = code;
        this.expired = LocalDateTime.now().plusSeconds(expired);
    }

    /**
     * @return boolean
     * @description 验证验证码是否过期
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    public boolean isExpired() {
        return expired.isBefore(LocalDateTime.now());
    }

}
