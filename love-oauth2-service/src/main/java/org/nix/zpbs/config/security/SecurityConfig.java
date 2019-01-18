package org.nix.zpbs.config.security;

import org.nix.zpbs.config.properties.constants.DefaultConstants;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.service.impl.UserDetailsServiceImpl;
import org.nix.zpbs.utils.verification.ValidateCodeFilter;
import org.nix.zpbs.utils.verification.image.ImageConfirmationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.ServletException;

/**
 * 启用方法级别的权限认证
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/13
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(value = SecurityProperties.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Resource
    private SecurityProperties securityProperties;

    @Resource
    private LoveAuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Resource
    private LoveAuthenticationFailHandler loveAuthenticationFailHandler;

    @Autowired
    private ImageConfirmationCode imageConfirmationCode;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                // 添加一个过滤器再某个过滤前面
                        addFilterBefore(getValidateCodeFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                // 设置登陆成功后如何跳转处理
                .loginPage(DefaultConstants.DEFAULT_UNAUTHENTICATED_URL)
                // 登陆请求路径
                .loginProcessingUrl(DefaultConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(loveAuthenticationSuccessHandler)
                .failureHandler(loveAuthenticationFailHandler)
                .and()
                .authorizeRequests()
                // 配置的登陆页应该不用权限
                .antMatchers(
                        securityProperties.getBrowser().getLoginPage()
                        , DefaultConstants.DEFAULT_UNAUTHENTICATED_URL
                        , DefaultConstants.DEFAULT_LOGIN_HEMTP_PACK
                        , DefaultConstants.DEFAULT_STATIC_LOGIN_PAGE_URL).permitAll()
                // 验证码控制器的请求不用认证
                .antMatchers("/verification/**").permitAll()
                // 所有请求都需要认证
                .anyRequest()
                .authenticated()
                // 关闭防止跨站请求的处理
                .and()
                .csrf().disable();
    }

    private ValidateCodeFilter getValidateCodeFilter() throws ServletException {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.setAuthenticationFailureHandler(loveAuthenticationFailHandler);
        validateCodeFilter.setImageConfirmationCode(imageConfirmationCode);
        validateCodeFilter.afterPropertiesSet();
        return validateCodeFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        String password = "bisha520";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
        System.out.println(encode.length());
    }

}
