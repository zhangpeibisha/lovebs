package org.nix.zpbs.config;


//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 暂时废弃掉，后续需要的时候再启用
 * TODO 权限控制配置暂时废弃掉，后续需要的时候再启用
 * //  启用方法级别的权限认证
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/13
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
//        extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //  允许所有用户访问"/"和"/index.html"
//        http.authorizeRequests()
//                .antMatchers("/", "/index.html","/user/info").permitAll()
//                // 其他地址的访问均需验证权限
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                //  登录页
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/index.html");
//    }

}
