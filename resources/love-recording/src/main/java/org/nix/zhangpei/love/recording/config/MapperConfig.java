package org.nix.zhangpei.love.recording.config;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.nix.zhangpei.love.recording.dao.tx.CommentMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MapperConfig{

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.zhuma.demo.mapper");

        Properties properties = new Properties();
        properties.setProperty("mappers", CommentMapper.class.getName());
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        properties.setProperty("ORDER","BEFORE");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }


}
