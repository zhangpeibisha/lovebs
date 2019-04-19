package org.nix.lovedomain.security.app.validate.code.impl;

import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCode;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeException;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeRepository;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangpei
 * @version 1.0
 * @description redis存储验证码信息
 * @date 2019/2/3
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @param request      用户请求
     * @param validateCode 验证码
     * @param codeType     验证码类型
     * @return void
     * @description 保存验证码信息，设置过期时间配置 securityProperties.getRedisExpired() 单位秒
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @Override
    public void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeType codeType) {
        redisTemplate.opsForValue()
                .set(builderKey(request, codeType), validateCode, securityProperties.getRedisExpired(), TimeUnit.SECONDS);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType codeType) {
        Object o = redisTemplate.opsForValue().get(builderKey(request, codeType));
        if (o == null){
            return null;
        }
        return (ValidateCode) o;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        redisTemplate.delete(builderKey(request,codeType));
    }

    /**
     * @param request
     * @param codeType
     * @return java.lang.String
     * @description 创建key
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    private String builderKey(ServletWebRequest request, ValidateCodeType codeType) {
        String deviceIdStr = "deviceId";
        String deviceId = request.getHeader(deviceIdStr);
        if (deviceId == null) {
            throw new ValidateCodeException("请在请求头中携带" + deviceIdStr + "参数");
        }
        return "code" + codeType.toString().toUpperCase() + ":" + deviceId;
    }

}
