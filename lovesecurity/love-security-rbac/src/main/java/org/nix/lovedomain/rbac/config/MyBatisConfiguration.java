package org.nix.lovedomain.rbac.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhangpei
 * @version 1.0
 * @description mybatis分页插件
 * @date 2019/2/18
 */
@Configuration
public class MyBatisConfiguration {

	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
