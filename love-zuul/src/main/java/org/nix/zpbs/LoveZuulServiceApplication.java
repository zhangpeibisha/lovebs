package org.nix.zpbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class LoveZuulServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveZuulServiceApplication.class,args);
    }
}
