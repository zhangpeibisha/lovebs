package org.nix.zpbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@SpringBootApplication
@EnableEurekaServer
public class LoveEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveEurekaApplication.class,args);
    }
}
