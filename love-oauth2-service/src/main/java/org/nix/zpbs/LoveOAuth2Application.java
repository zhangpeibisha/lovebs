package org.nix.zpbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@SpringBootApplication
public class LoveOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(LoveOAuth2Application.class,args);
    }
}