package org.nix.lovedomain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/18
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value="org.nix.lovedomain.rbac.dao")
@EnableScheduling
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
