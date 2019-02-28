package org.nix.lovedomain.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description Oss配置类
 * @date 2019/2/28
 */
@Data
@Component
@ConfigurationProperties(prefix = "oss.client")
public class OssProperties {

    /**
     * Endpoint默认北京接口
     */
    String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    /**
     * 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。
     * 强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
     * 账户信息
     */
    String accessKeyId = "LTAImLa8KD2ODgJk";
    String accessKeySecret = "skRnPiNJC4ZgnzYloVfFfYYmMWr31b";
}
