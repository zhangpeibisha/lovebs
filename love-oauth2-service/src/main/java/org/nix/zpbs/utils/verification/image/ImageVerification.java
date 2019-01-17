package org.nix.zpbs.utils.verification.image;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.exception.ServiceException;
import org.nix.zpbs.utils.verification.ValidateCodeException;
import org.nix.zpbs.utils.verification.VerificationCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

/**
 * 图片验证
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Slf4j
public class ImageVerification implements VerificationCode {

    private final String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";

    private Producer producer = producer();

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

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
            // 生成验证码文本
            String capText = producer.createText();
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
            log.info("生成验证码文本信息:{}", capText);
            // 利用生成的字符串构建图片
            BufferedImage bi = producer.createImage(capText);
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            session.setAttribute(SESSION_KEY_IMAGE_CODE,
                    new ImageCode(bi, capText, securityProperties.getValidate().getExpired()));
        } catch (IOException e) {
            log.error("图片验证码生成失败:{}", e);
            throw new ServiceException("验证码生成失败");
        }
    }

    @Override
    public void submitVerification(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        checkCodeEnable(request);
    }

    /**
     * 检查验证码是否可用
     * @param request 用户请求
     * @throws AuthenticationException 权限异常
     */
    private void checkCodeEnable(HttpServletRequest request) throws AuthenticationException {
        ServletWebRequest webRequest = new ServletWebRequest(request);
        ImageCode imageCode = (ImageCode) sessionStrategy
                .getAttribute(webRequest, SESSION_KEY_IMAGE_CODE);
        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(webRequest.getRequest(),
                    securityProperties.getValidate().getRequestValidateKey());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码失败");
        }
        if (imageCode == null) {
            throw new ValidateCodeException("验证码尚未生成，不可验证");
        }
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("输入的验证码不能为空");
        }
        if (imageCode.isExpired()) {
            sessionStrategy.removeAttribute(webRequest,SESSION_KEY_IMAGE_CODE);
            throw new ValidateCodeException("验证码已经过期，请重新申请");
        }
        if (!imageCode.getCode().equals(codeInRequest)) {
            throw new ValidateCodeException("验证码输入错误，请重新输入");
        }
        sessionStrategy.removeAttribute(webRequest,SESSION_KEY_IMAGE_CODE);
    }

    private HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    /**
     * @return 验证码工具对象
     */
    private Producer producer() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config());
        return defaultKaptcha;
    }

    /**
     * 图片验证码配置
     *
     * @return 图片验证码配置
     */
    private Config config() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "134");
        properties.setProperty("kaptcha.image.height", "35");
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.char.space", "6");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        return new Config(properties);
    }
}
