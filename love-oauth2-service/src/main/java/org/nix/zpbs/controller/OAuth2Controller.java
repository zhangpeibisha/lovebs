package org.nix.zpbs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.pojo.base.BaseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 跳转有问题
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@Slf4j
@Api(value = "权限相关控制器")
@RestController
public class OAuth2Controller {

    @Resource
    private SecurityProperties securityProperties;

    // 对请求进行转发需要的对象
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @ApiOperation(value = "其他系统获取用户认证信息")
    @GetMapping(value = "/user",produces = "application/json")
    public Map<String,Object> user(OAuth2Authentication user){
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities",AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }

    @ApiOperation(value = "需要身份验证时跳转到这里进行判断，如果是浏览器直接返回html，如果是APP返回401错误代码")
    @ApiResponse(code = 401,response = Exception.class,message = "用户尚未认证，请进入登陆页进行验证")
    @RequestMapping(value = "/authentication/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResult requireAuthentication(HttpServletRequest request, HttpServletResponse response){
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if (savedRequest !=null){
            String target = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是：{}",target);
            String htmlEnd = ".html";
            if (target.endsWith(htmlEnd)){
                try {
                    redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
                } catch (IOException e) {
                    log.error("跳转{}失败:{}",target,e.getMessage());
                }
            }
        }
        return new BaseResult().fail(401,"访问的用户需要身份认证，请前往登录页");
    }

}
