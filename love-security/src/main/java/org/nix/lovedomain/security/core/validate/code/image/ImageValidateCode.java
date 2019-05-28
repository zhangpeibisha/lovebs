package org.nix.lovedomain.security.core.validate.code.image;

import lombok.Data;
import org.nix.lovedomain.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * @author zhangpei
 * @version 1.0
 * @description 图片验证码实体类
 * @date 2019/1/27
 */
@Data
public class ImageValidateCode extends ValidateCode implements Serializable {

    /**
     * 图片信息流不用序列化
     */
    private transient BufferedImage image;

    public ImageValidateCode(String code, Integer expired, BufferedImage image) {
        super(code, expired);
        this.image = image;
    }
}
