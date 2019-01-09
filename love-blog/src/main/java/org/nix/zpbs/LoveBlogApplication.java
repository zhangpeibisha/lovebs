package org.nix.zpbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@SpringBootApplication
//@EnableEurekaClient
@MapperScan(basePackages = {"org.nix.zpbs.dao","org.nix.zpbs.mapper"})
public class LoveBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveBlogApplication.class,args);
    }
}
