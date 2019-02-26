package org.nix.lovedomain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangpei
 * @version 1.0
 * @description 启动类
 * @date 2019/2/24
 */
@SpringBootApplication
@MapperScan(value = "org.nix.lovedomain.photo.mapper")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
