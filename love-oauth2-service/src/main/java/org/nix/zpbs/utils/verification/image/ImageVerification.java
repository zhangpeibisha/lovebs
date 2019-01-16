package org.nix.zpbs.utils.verification.image;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.exception.ServiceException;
import org.nix.zpbs.utils.verification.VerificationCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.naming.AuthenticationException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 图片验证
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Slf4j
@Component
public class ImageVerification implements VerificationCode {

    private final String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";

    @Resource
    private Producer producer;

    @Resource
    private SecurityProperties securityProperties;

    @Override
    public void createVerification(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = getSession(request);

            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");
            //生成验证码文本
            String capText = producer.createText();
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
            log.debug("生成验证码文本信息:{}",capText);
            //利用生成的字符串构建图片
            BufferedImage bi = producer.createImage(capText);
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            session.setAttribute(SESSION_KEY_IMAGE_CODE,new ImageCode(bi,capText,securityProperties.getValidate().getExpired()));
        } catch (IOException e) {
            log.error("图片验证码生成失败:{}",e);
            throw new ServiceException("验证码生成失败");
        }
    }

    @Override
    public void submitVerification(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        checkCodeEnable(request);
    }


    private void checkCodeEnable(HttpServletRequest request) throws AuthenticationException {
        // 获取输入的值
        String submitValue = request.getParameter(
                securityProperties.getValidate().getRequestValidateKey());
        // 获取到session中的值
        HttpSession session = getSession(request);
        ImageCode imageCode = (ImageCode) session
                .getAttribute(SESSION_KEY_IMAGE_CODE);
        if (imageCode == null){
            throw new AuthenticationException("验证码尚未生成，不可验证");
        }
        if (StringUtils.isBlank(submitValue)){
            throw new AuthenticationException("输入的验证码不能为空");
        }
        if (imageCode.isExpired()) {
            session.removeAttribute(SESSION_KEY_IMAGE_CODE);
            throw new AuthenticationException("验证码已经过期，请重新申请");
        }
        if (!imageCode.getCode().endsWith(submitValue)){
            throw new AuthenticationException("验证码输入错误，请重新输入");
        }
        session.removeAttribute(SESSION_KEY_IMAGE_CODE);
    }

    private HttpSession getSession(HttpServletRequest request){
        return request.getSession();
    }
}
