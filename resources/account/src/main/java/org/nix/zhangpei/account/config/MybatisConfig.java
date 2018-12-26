package org.nix.zhangpei.account.config;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/24
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MybatisConfig {


}
