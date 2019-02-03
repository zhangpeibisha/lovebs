package org.nix.lovedomain.security.app.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author zhangpei
 * @version 1.0
 * @description 认证成功处理器
 * @date 2019/1/27
 * @see BasicAuthenticationFilter 仿照该类doFilater
 */
@Slf4j
@Component("loveAuthenticationSuccessHandler")
public class LoveAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

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
        //1.拿到请求中的 Authorization ==> 包含了第三方应用的账号和密码
        String header = request.getHeader("Authorization");
        // 检测该值是否为空或者是否以 Basic 为开始
        String basic = "Basic ";
        if (header == null || !header.startsWith(basic)) {
            throw new UnapprovedClientAuthenticationException("请求头中无client信息");
        }
        // 开始解码获取客户端信息
        String[] tokens = this.extractAndDecodeHeader(header, request);
        assert tokens.length == 2;
        String clientId = tokens[0];
        String clientSecret = tokens[1];
        // 通过id获取客户端详情
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
        // 校验信息是否正确和期望的
        if (clientDetails == null){
            log.info("client id:{} 没有在本系统注册",clientId);
            throw new UnapprovedClientAuthenticationException("client id 没有在本系统注册");
        }
        if (!clientDetails.getClientSecret().equals(clientSecret)){
            log.info("client Secret 不匹配，client id:{} ",clientId);
            throw new UnapprovedClientAuthenticationException("client Secret 不匹配");
        }
        HashMap<String, String> requestParameters = new HashMap<>();
        TokenRequest tokenRequest = new TokenRequest(requestParameters,clientId,clientDetails.getScope(),"custom");

        OAuth2Request oAuth2Request =tokenRequest.createOAuth2Request(clientDetails);

        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request,authentication);
        OAuth2AccessToken accessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(accessToken));

    }

    /**
     * @param header
     * @param request
     * @return java.lang.String[]
     * @description 对请求头中的第三方信息进行解码
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
        byte[] base64Token = header.substring(6).getBytes("UTF-8");

        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException var7) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded,"UTF-8");
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        } else {
            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
        }
    }
}
