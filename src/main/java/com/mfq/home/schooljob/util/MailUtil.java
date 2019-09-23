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

    private static void sendText(String subject,String from,String to,String text) throws SendMailException {
        OhMyEmail.subject(subject)
                .from(from)
                .to(to)
                .text(text)
                .send();
    }

}
