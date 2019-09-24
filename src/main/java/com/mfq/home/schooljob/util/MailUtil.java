package com.mfq.home.schooljob.util;

import io.github.biezhi.ome.OhMyEmail;
import io.github.biezhi.ome.SendMailException;

import java.util.Properties;

public class MailUtil {

    private static Properties prop =PropsUtil.loadProps("mail.properties");;
    private static String username = String.valueOf(prop.getProperty("email.username"));
    private static String password = String.valueOf(prop.getProperty("email.password"));
    static {
        OhMyEmail.config(OhMyEmail.SMTP_QQ(false), username, password);
    }

    public static void sendText(String subject,String from,String to,String text) throws SendMailException {
        OhMyEmail.subject(subject)
                .from(from)
                .to(to)
                .text(text)
                .send();
    }

    public static void main(String[] args) {
        try {
            
            sendText("邮件测试","2874290468@qq.com","824717045@qq.com","邮件正文");
        } catch (SendMailException e) {
            e.printStackTrace();
        }
    }



}
