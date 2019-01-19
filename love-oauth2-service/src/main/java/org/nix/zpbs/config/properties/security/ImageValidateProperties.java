package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/20
 */
@Data
public class ImageValidateProperties extends SmsValidateProperties{

    /**
     * 超时时间
     */
    private int expireIn = 60;

    /**
     * 配置图片的生成参数的文件的名字
     * 默认名字为 image.properties
     */
    private String imageConfigFileName = "image.properties";
}
