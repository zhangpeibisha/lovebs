package org.nix.zpbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.nix.zpbs.dao","org.nix.zpbs.mapper"})
@EnableTransactionManagement
public class LoveOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(LoveOAuth2Application.class,args);
    }
}
