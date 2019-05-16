package org.nix.lovedomain.component.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhangpei
 * @version 1.0
 * @description 邮件服务配置
 * @date 2019/4/28
 */
@Configuration
public class EmailConfig {

    @Bean
    public EmailTemplate emailTemplate(){
        return new EmailTemplate();
    }


}
