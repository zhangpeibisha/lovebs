package org.nix.zhangpei.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
@SpringBootApplication
@MapperScan(value = "org.nix.zhangpei.account.dao")
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }

}
