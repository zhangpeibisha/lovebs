package org.nix.lovedomain.rbac.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangpei
 * @version 1.0
 * @description 日志工厂
 * @date 2019/2/18
 */
@Slf4j
public class LogFactory {

    public static void info(String text) {
        log.info(text);
    }

    public static void debug(String text) {
        log.debug(text);
    }

    public static void error(String text) {
        log.error(text);
    }
}
