package org.nix.lovedomain.service;

import org.nix.lovedomain.utils.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangpei
 * @version 1.0
 * @description 邮箱服务
 * @date 2019/4/28
 */
@Service
public class EmailService {

    @Autowired
    private EmailTemplate emailTemplate;


    public void sendQuestionTask(EmailTemplate.EmailText emailText){
        emailTemplate.sendTextEmail(emailText);
    }

}
