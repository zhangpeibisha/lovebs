package org.nix.lovedomain.security.core.validate.code.image;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.properties.ImageProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCode;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeGenerator;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author zhangpei
 * @version 1.0
 * @description 图片验证码生成器，采用谷歌的开源框架
 * @date 2019/1/27
 */
@Data
@Slf4j
public class ImageValidateCodeGenerator implements ValidateCodeGenerator {

    /**
     * 用户自定义信息
     */
    private ImageProperties imageProperties;


    /**
     * @return org.nix.lovedomain.security.core.validate.code.ValidateCode
     * @description 生产出一个图片验证码信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    public ValidateCode generator() {
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(getConfig());
        String text = kaptcha.createText();
        BufferedImage image = kaptcha.createImage(text);
        return new ImageValidateCode(text, imageProperties.getExpired()
                , image);
    }

    /**
     * @return com.google.code.kaptcha.util.Config
     * @description 获取配置文件信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    private Config getConfig() {
        if (imageProperties.getPropertiesPath() == null) {
            return getDefaultConfig();
        }
        try {
            return getCustomizeConfig();
        } catch (IOException e) {
            log.warn("用户的图片自定义配置信息异常：{}", e.getMessage());
            log.info("使用默认配置顶替自定义配置");
            return getDefaultConfig();
        }
    }

    /**
     * @return com.google.code.kaptcha.util.Config
     * @description 获取用户配置的图片验证码信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    private Config getCustomizeConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(imageProperties.getPropertiesPath()));
        return new Config(properties);
    }

    /**
     * @return com.google.code.kaptcha.util.Config
     * @description 获取到默认的图片信息配置
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    private Config getDefaultConfig() {
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
