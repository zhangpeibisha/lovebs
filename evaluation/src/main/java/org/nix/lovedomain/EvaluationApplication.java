package org.nix.lovedomain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangpei
 * @version 1.0
 * @description 评教系统
 * @date 2019/3/4
 */
@SpringBootApplication
@EnableAsync
@MapperScan(value = {"org.nix.lovedomain.dao.mapper", "org.nix.lovedomain.dao.business"})
@tk.mybatis.spring.annotation.MapperScan(basePackages  = {"org.nix.lovedomain.dao.business.*BusinessMapper"})
@EnableTransactionManagement
public class EvaluationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvaluationApplication.class, args);
    }

}
