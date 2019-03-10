package org.nix.lovedomain.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.properties.LoginResponseType;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 认证成功处理器
 * @date 2019/1/27
 */
@Slf4j
public class LoveAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @param request        用户请求
     * @param response       用户响应
     * @param authentication 用户权限信息
     * @return void
     * @description 认证成功过后处理用户下一步页面
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        log.info("登录成功");
        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            json(response,authentication);
        } else {
            redirect(request,response,authentication);
        }
    }

    protected void json(HttpServletResponse response,
                      Authentication authentication) throws IOException {
        log.info("json登陆");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authentication));
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("跳转类型登陆");
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
