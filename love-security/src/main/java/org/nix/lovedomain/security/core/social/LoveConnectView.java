package org.nix.lovedomain.security.core.social;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @description 解绑和绑定状态展示页面
 * @date 2019/1/31
 */
public class LoveConnectView extends AbstractView {
    /**
     * @param model
     * @param request
     * @param response
     * @return void
     * @description 当用户操作第三方应用的解绑和绑定操作的反馈信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        String connection = "connection";
        if (model.get(connection) == null) {
            response.getWriter().write("<h3>解绑成功</h3>");
        } else {
            response.getWriter().write("<h3>绑定成功</h3>");
        }

    }
}
