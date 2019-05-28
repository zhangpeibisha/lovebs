package org.nix.lovedomain.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码保存、验证、删除的操作定义接口
 * @date 2019/2/3
 */
public interface ValidateCodeRepository {

    /**
     * @param request      用户请求封装
     * @param validateCode 验证码实体
     * @param codeType     验证码类型
     * @return void
     * @description 保存验证码
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeType codeType);

    /**
     * @param request  用户请求
     * @param codeType 验证码类型
     * @return ValidateCode
     * @description 获取验证码信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    ValidateCode get(ServletWebRequest request, ValidateCodeType codeType);

    /**
     * @param request  用户请求
     * @param codeType 验证码类型
     * @return void
     * @description 移除验证码
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    void remove(ServletWebRequest request, ValidateCodeType codeType);


}
