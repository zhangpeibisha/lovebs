package org.nix.zpbs.utils.verification;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/19
 */
@Data
public class ValidateCode implements Serializable {
    /**
     * 验证码
     */
    private String code;
    /**
     * 验证码过期时间 单位秒
     */
    private LocalDateTime expired;

    public ValidateCode( String code, int expired) {
        this.code = code;
        this.expired = LocalDateTime.now().plusSeconds(expired);
    }

    /**
     * @return 如果时间过期则返回true,否则返回false
     * @author zhangpe0312@qq.com
     * @date 0:40 2019/1/17
     */
    public boolean isExpired() {
        return expired.isBefore(LocalDateTime.now());
    }
}
