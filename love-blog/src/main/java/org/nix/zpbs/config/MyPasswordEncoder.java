package org.nix.zpbs.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/13
 */
@Slf4j(topic = "MyPasswordEncoder配置")
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        log.info("密码encode()中输入了：{}",charSequence);
        return "bisha520";
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        log.info("matches()中输入了：{} and {}",charSequence,s);
        return true;
    }
}
