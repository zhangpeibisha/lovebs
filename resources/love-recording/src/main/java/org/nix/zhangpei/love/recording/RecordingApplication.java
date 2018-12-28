package org.nix.zhangpei.love.recording;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
@SpringBootApplication
@MapperScan(basePackages = "org.nix.zhangpei.love.recording.dao.mapper")
public class RecordingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecordingApplication.class,args);
    }
}
