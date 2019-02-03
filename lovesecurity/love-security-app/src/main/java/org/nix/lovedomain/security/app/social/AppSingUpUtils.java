package org.nix.lovedomain.security.app.social;

import org.apache.commons.lang.StringUtils;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangpei
 * @version 1.0
 * @description 在无session环境中 第三方应用工具类
 * @date 2019/2/3
 */

@Component
public class AppSingUpUtils {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @param request
     * @param connectionData
     * @return void
     * @description 保存社交用户信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    public void saveConnectionData(WebRequest request, ConnectionData connectionData) {
        redisTemplate.opsForValue().set(getKey(request), connectionData, securityProperties.getRedisExpired(), TimeUnit.SECONDS);
    }

    /**
     * @param request
     * @param userId
     * @return void
     * @description 将第三方的用户信息和本系统的用户信息绑定
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    public void doPostSignUp(WebRequest request, String userId) {
        String key = getKey(request);
        if (!redisTemplate.hasKey(key)) {
            throw new AppSecretException("无法找到缓存的用户社交账号信息");
        }
        ConnectionData connectionData = (ConnectionData) redisTemplate.opsForValue().get(key);
        Connection<?> connection = connectionFactoryLocator.getConnectionFactory(connectionData.getProviderId())
                .createConnection(connectionData);
        usersConnectionRepository.createConnectionRepository(userId).addConnection(connection);

        redisTemplate.delete(key);
    }

    private String getKey(WebRequest request) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new AppSecretException("设备id参数不能为空");
        }
        return "love:security:social.connect." + deviceId;
    }

}
