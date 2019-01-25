package org.nix.zpbs.utils.verification.image;

import lombok.Data;
import org.nix.zpbs.utils.verification.ValidateCode;

import java.awt.image.BufferedImage;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
@Data
public class ImageCode extends ValidateCode {

    /**
     * 图片不用序列化
     */
    private transient BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expired) {
        super(code, expired);
        this.image = image;
    }

}
