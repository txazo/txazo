package org.txazo.blog.module.email.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.*;

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

    private ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500));

    @Resource
    private JavaMailSender javaMailSender;

    public void sendValidateEmail(String email, String authCode) {
        Boolean result = false;
        Future<Boolean> future = threadPool.submit(new SendEmailCallback(email, authCode));
        try {
            result = future.get(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class SendEmailCallback implements Callable<Boolean> {

        private String email;
        private String authCode;

        public SendEmailCallback(String email, String authCode) {
            this.email = email;
            this.authCode = authCode;
        }

        @Override
        public Boolean call() throws Exception {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(email);
            mail.setFrom(from);
            mail.setSubject("欢迎注册tbog");
            mail.setText("点击链接" + getValidateEmailUrl() + "验证邮箱");

            javaMailSender.send(mail);
            return Boolean.TRUE;
        }

        private String getValidateEmailUrl() {
            return "http://127.0.0.1:8080/email/validate?email=" + email + "&code" + authCode;
        }

    }

}
