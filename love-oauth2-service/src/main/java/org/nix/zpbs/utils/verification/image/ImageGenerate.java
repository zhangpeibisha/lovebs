package org.nix.zpbs.utils.verification.image;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.utils.verification.Generate;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

/**
 * 图片验证码生成器
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
@Slf4j
public class ImageGenerate implements Generate {

    @Resource
    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate() {
        // 配置生成器
        Producer producer = new DefaultKaptcha();
        ((DefaultKaptcha) producer).setConfig(config());
        // 生成文字
        String code = producer.createText();
        // 创建图片流
        BufferedImage image = producer.createImage(code);
        return new ImageCode(image, code,
                securityProperties.getValidate().getImage().getExpireIn());
    }

    /**
     * 图片验证码配置
     *
     * @return 图片验证码配置
     */
    private Config config() {
        Properties properties = new Properties();
        try {
            // 如果加载配置文件失败，则使用默认值
            properties.load(ImageGenerate.class.getClassLoader()
                    .getResourceAsStream(securityProperties.getValidate()
                            .getImage()
                            .getImageConfigFileName()));
        } catch (IOException e) {
            log.warn("图片加载配置文件失败{}", e.getMessage());
            // 如果动态加载数据错误，则使用默认的加载
            return defaultConfig();
        }
        return new Config(properties);
    }

    private Config defaultConfig() {
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
