package org.nix.lovedomain.rbac.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 定时任务
 * @date 2019/2/18
 */
@Component
public class TimeSchedule {
    /**
     * 定时任务，每个一分钟打印当前时间
     */
    @Scheduled(fixedRate = 1 * 60 * 1000)
    public void printTime() {
        LogFactory.info("当前时间为:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
