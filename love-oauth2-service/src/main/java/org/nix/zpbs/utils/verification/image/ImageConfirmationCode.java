package org.nix.zpbs.utils.verification.image;

import org.nix.zpbs.utils.verification.AbstractConfirmationCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * 图片验证码处理器
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/19
 */
@Component("imageConfirmationCode")
public class ImageConfirmationCode extends AbstractConfirmationCode<ImageCode> {

    @Override
    protected void send(ServletWebRequest request, ImageCode generate) throws Exception {
        assert request.getResponse() != null;
        ImageIO.write(generate.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
