package org.nix.lovedomain.security.browser.logout;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.dto.BaseResultDTO;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 系统退出成功处理器
 * @date 2019/2/1
 */
@Slf4j
public class LoveLogoutSuccessHandler implements LogoutSuccessHandler {

    private String logoutUrl;

    public LoveLogoutSuccessHandler(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication)
            throws IOException, ServletException {
        log.info("退出成功");
        if (logoutUrl.equals(SecurityConstants.DEFAULT_LOGOUT_PAGE_URL)){
            log.info("没有设置退出页面，返回一个json表示退出成功");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(new BaseResultDTO("退出成功",HttpStatus.OK)));
        }else {
            log.info("设置了退出页面，{}",logoutUrl);
            httpServletResponse.sendRedirect(logoutUrl);
        }
    }
}
