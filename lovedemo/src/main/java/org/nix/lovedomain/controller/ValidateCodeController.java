package org.nix.lovedomain.controller;

import org.nix.lovedomain.security.core.properties.ImageProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCode;
import org.nix.lovedomain.security.core.validate.code.image.ImageValidateCode;
import org.nix.lovedomain.security.core.validate.code.image.ImageValidateCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码控制器
 * @date 2019/1/27
 */
@Controller
public class ValidateCodeController {

    @GetMapping("/image/code")
    public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 60);
        ImageValidateCodeGenerator imageValidateCodeGenerator = new ImageValidateCodeGenerator(new ImageProperties());
        ImageValidateCode generator = (ImageValidateCode) imageValidateCodeGenerator.generator();
        BufferedImage image = generator.getImage();
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"jpg",outputStream);
        try {
            outputStream.flush();
        }finally {
            outputStream.close();
        }
    }

}
