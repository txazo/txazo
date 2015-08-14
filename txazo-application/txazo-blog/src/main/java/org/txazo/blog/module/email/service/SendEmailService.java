package org.txazo.blog.module.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.txazo.blog.module.email.bean.Email;

/**
 * SendEmailService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Component
public class SendEmailService {

    @Value("${email.from}")
    private String from;

    @Autowired
    private SendEmailQueue sendEmailQueue;

    public void sendValidateEmail(String to, String authCode) {
        Email email = new Email();
        email.setFrom(from);
        email.setTo(to);
        email.setSubject("tblog注册验证邮箱");
        email.setContent(createValidateContent(to, authCode));
        email.setHtml(true);

        sendEmailQueue.push(email);
    }

    private String createValidateContent(String to, String authCode) {
        return "http://127.0.0.1:8080/email/validate?email=" + to + "&code=" + authCode;
    }

}
