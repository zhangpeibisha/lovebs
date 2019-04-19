package org.nix.lovedomain.security.core.social.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description Weixin API调用模板， scope为Request的Spring bean, 根据当前用户的accessToken创建。
 * @date 2019/2/1
 */
@Slf4j
public class WeixinImpl extends AbstractOAuth2ApiBinding implements Weixin {
    /**
     * json工具
     */
    private ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 获取用户信息的url
     */
    private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

    /**
     * @param accessToken 用户授权获取的口令
     */
    public WeixinImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    /**
     * @return java.util.List<org.springframework.http.converter.HttpMessageConverter       <       ?>>
     * @description 默认注册的StringHttpMessageConverter字符集为ISO-8859-1，而微信返回的是UTF-8的，所以覆盖了原来的方法。
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }

    /**
     * @param openId 用户唯一id在微信服务中的
     * @return org.nix.lovedomain.security.core.social.weixin.api.WeixinUserInfo
     * @description 获取微信用户信息，如果返回信息中存在 errcode则表示获取失败返回null
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Override
    public WeixinUserInfo getUserInfo(String openId) {
        String url = URL_GET_USER_INFO + openId;
        String response = getRestTemplate().getForObject(url, String.class);
        String errcode = "errcode";
        if (StringUtils.contains(response, errcode)) {
            log.info("获取微信用户信息失败，返回错误码为:{}",errcode);
            return null;
        }
        WeixinUserInfo profile = null;
        try {
            profile = objectMapper.readValue(response, WeixinUserInfo.class);
        } catch (Exception e) {
            log.warn("解析微信用户信息失败：{}",e.getMessage());
            e.printStackTrace();
        }
        return profile;
    }
}
