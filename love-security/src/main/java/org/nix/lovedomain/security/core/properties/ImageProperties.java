package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 图片自定义配置信息
 * @date 2019/1/27
 */
@Data
public class ImageProperties {

    /**
     * 图片验证码过期时间,默认为60秒
     */
    private Integer expired = 60;
    /**
     * 图片验证码自定义路径
     */
    private String propertiesPath;
    /**
     * 需要图片验证的路径
     */
    private String validateUrls;
}
