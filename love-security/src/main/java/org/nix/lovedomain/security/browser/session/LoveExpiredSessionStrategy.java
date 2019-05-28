package org.nix.lovedomain.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description session超时处理策略
 * @date 2019/2/1
 */
public class LoveExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public LoveExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    /**
     * @param event
     * @return void
     * @description 功能描述
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     * @see org.springframework.security.web.session.SessionInformationExpiredStrategy#onExpiredSessionDetected(org.springframework.security.web.session.SessionInformationExpiredEvent)
     */
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    /**
     * @return boolean
     * @description 判断是否超时
     * @see AbstractSessionStrategy#isConcurrency()
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
