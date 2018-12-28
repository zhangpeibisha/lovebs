package org.nix.zhangpei.love.recording.controller.dto;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public interface CheckRequest {
    /**
     * 判断请求是否通过校验
     * @return 如果通过则返回true
     * @throws CheckException 校验异常
     */
    boolean pass() throws CheckException;

}
