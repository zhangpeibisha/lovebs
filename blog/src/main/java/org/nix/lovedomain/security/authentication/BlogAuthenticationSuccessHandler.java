package org.nix.lovedomain.security.authentication;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.browser.authentication.LoveAuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 博客权限认证成功处理器
 * @date 2019/3/10
 */
@Slf4j
@Component
public class BlogAuthenticationSuccessHandler extends LoveAuthenticationSuccessHandler {

    @Override
    protected void redirect(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("跳转类型登陆");
        response.sendRedirect(securityProperties.getBrowser().getLoginSuccessPage());
    }
}
