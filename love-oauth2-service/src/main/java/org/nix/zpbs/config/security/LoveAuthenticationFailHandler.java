package org.nix.zpbs.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.config.properties.security.BrowserProperties;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败处理器
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/16
 */
@Component
@Slf4j
public class LoveAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private SecurityProperties securityProperties;

    /**
     * 登陆失败处理
     * @param httpServletRequest 用户请求
     * @param httpServletResponse 用户响应
     * @param e 包含了用户认证发生的错误
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        log.info("用户登陆失败");
        if (BrowserProperties.LoginType.JSON.
                equals(securityProperties.getBrowser().getLoginType())){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(e));
        }else {
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }
    }
}
