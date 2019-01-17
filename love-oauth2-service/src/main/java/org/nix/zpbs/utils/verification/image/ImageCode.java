package org.nix.zpbs.utils.verification.image;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 图形验证码信息实体
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;
    /**
     * 验证码过期时间 单位秒
     */
    private LocalDateTime expired;

    public ImageCode(BufferedImage image, String code, int expired) {
        this.image = image;
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

    public static void main(String[] args) throws InterruptedException {

    }
}
