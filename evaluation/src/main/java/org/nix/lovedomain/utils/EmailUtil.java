package org.nix.lovedomain.utils;

import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
public class EmailUtil {

    private final static String SUBJECT = "【重庆理工大学评教系统】";

    public static void sendEmail(String content, List<String> addressList){

        if(addressList != null && addressList.size() != 0){
            for (String adr:
                    addressList) {
                try {
                    MailUtil.send(adr, SUBJECT, content, false);
                }catch (Exception e){
                    LogUtil.logWarn(log, "邮件发送失败：{}，发送地址:{}", e.getMessage(),adr);
                }

            }
        }


    }




}
