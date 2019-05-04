package org.nix.lovedomain.component.email;

import cn.hutool.core.collection.CollUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.utils.LogUtil;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhangpei
 */
@Slf4j
public class EmailTemplate {

    private String fromEmail = "hotspot2@163.com";
    private String password = "276412email";
    private Properties props = getEmailProperties();

    /**
     * 发送文本邮件
     *
     * @param email
     */
    public void sendTextEmail(EmailText email) {
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        Transport transport = null;
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setSubject(email.getSubject());
            ((MimeMessage) msg).setText(email.getContent(), "UTF-8");
            msg.setRecipients(Message.RecipientType.TO,
                    listStrEmailToAddressArr(email.getToAddress()));
            msg.saveChanges();
            transport = session.getTransport();
            transport.connect(fromEmail, password);
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (Exception e) {
            LogUtil.logWarn(log, "邮件发送失败：{}", e.getMessage());
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    LogUtil.logInfo(log, "关闭邮件发送失败:{}", e.getMessage());
                }
            }
        }
    }

    /**
     * 将字符串地址转为发送邮件需要的地址
     *
     * @param toAddress
     * @return
     * @throws AddressException
     */
    public InternetAddress[] listStrEmailToAddressArr(List<String> toAddress) throws AddressException {
        if (CollUtil.isEmpty(toAddress)) {
            return null;
        }
        int size = toAddress.size();
        InternetAddress[] addresses = new InternetAddress[size];
        List<InternetAddress> addressList = new ArrayList<>(size);
        for (String str : toAddress) {
            InternetAddress internetAddress = new InternetAddress(str);
            addressList.add(internetAddress);
        }
        return addressList.toArray(addresses);
    }

    /**
     * 得到了邮件配置
     *
     * @return
     */
    public Properties getEmailProperties() {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        // smtp服务器地址
        props.put("mail.smtp.host", "smtp.163.com");
        return props;
    }

    /**
     * 文本邮件
     */
    @Data
    public static class EmailText {
        private String subject;
        private String content;
        private List<String> toAddress;
    }

    /**
     * 模板邮件
     */
    @Data
    public static class EmailModel {
        private String subject;
        private String modelPath;
        private Map<String, Object> keyValue;
    }
}
