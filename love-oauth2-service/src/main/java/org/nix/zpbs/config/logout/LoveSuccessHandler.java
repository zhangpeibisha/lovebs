package org.nix.zpbs.config.logout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/25
 */
@Slf4j
public class LoveSuccessHandler implements LogoutSuccessHandler {



    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication)
            throws IOException, ServletException {
        log.info("退出成功");

    }
}
