package org.nix.lovedomain.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @version 1.0
 * @anthor on 2019/4/24
 * @since jdk8
 *
 * 邮件发送
 */
public class SendEmail {

    public static void sendEmail(String targetEmail,String endTime){
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host","smtp.163.com");// smtp服务器地址

        Session session = Session.getInstance(props);
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        try {
            msg.setSubject("【沛沛评教系统】");// 标题
            msg.setText("你好！你有未处理的问卷，请登录系统到个人中心查看，截至日期:"+endTime+",地址：www.zhangsenlin.cn");//正文
            msg.setFrom(new InternetAddress("hotspot2@163.com"));//发件人邮箱(我的163邮箱)
            msg.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(targetEmail)); //收件人邮箱(我的QQ邮箱)
            msg.saveChanges();
            Transport transport = session.getTransport();
            transport.connect("hotspot2@163.com","276412email");//发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("邮件发送成功...");
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
