package org.nix.zhangpei.love.recording.controller.controller.resolver;

import java.lang.annotation.*;

/**
 * 用于控制器获取当前用户信息
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/29
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface User {
}
