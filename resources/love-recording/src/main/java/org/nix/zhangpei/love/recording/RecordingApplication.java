package org.nix.zhangpei.love.recording;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
@SpringBootApplication
@MapperScan(value = "org.nix.zhangpei.love.recording.dao.mapper")
public class RecordingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecordingApplication.class,args);
    }
}
