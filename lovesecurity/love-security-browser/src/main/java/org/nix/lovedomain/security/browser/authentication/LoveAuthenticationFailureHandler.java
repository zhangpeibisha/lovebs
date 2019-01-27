package org.nix.lovedomain.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.browser.dto.BaseResultDTO;
import org.nix.lovedomain.security.core.properties.LoginResponseType;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器请求失败处理器
 * @date 2019/1/27
 */
@Component("loveAuthenticationFailureHandler")
@Slf4j
public class LoveAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        log.info("用户认证失败");
        log.info("用户认证失败原因：{}", exception.getMessage());
        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(
                    new BaseResultDTO(exception.getMessage(), HttpStatus.BAD_REQUEST)));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

}
