package org.nix.lovedomain.security.core.validate.code.image;

import org.nix.lovedomain.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 图片验证码处理器
 * @date 2019/1/27
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageValidateCode> {

    @Override
    protected void send(ServletWebRequest request, ImageValidateCode validateCode) throws IOException {
        ImageIO.write(validateCode.getImage(), "JPEG",
                request.getResponse().getOutputStream());
    }
}
