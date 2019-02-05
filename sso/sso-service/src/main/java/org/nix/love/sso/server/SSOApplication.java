package org.nix.love.sso.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangpei
 * @version 1.0
 * @description 单点登陆入口
 * @date 2019/2/5
 */
@SpringBootApplication
public class SSOApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSOApplication.class,args);
    }

}
