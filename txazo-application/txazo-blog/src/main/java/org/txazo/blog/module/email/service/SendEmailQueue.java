package org.txazo.blog.module.email.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.txazo.blog.module.email.bean.Email;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.*;

/**
 * SendEmailQueue
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
@Component
public class SendEmailQueue {

    @Resource
    private JavaMailSender javaMailSender;

    private ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500));

    public void push(Email email) {
        Future<Boolean> future = threadPool.submit(new SendEmailCallback(email));
        try {
            future.get(15, TimeUnit.SECONDS);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
    }

    private class SendEmailCallback implements Callable<Boolean> {

        private Email email;

        public SendEmailCallback(Email email) {
            this.email = email;
        }

        @Override
        public Boolean call() throws Exception {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), email.isHtml());
            javaMailSender.send(mimeMessage);
            return Boolean.TRUE;
        }

    }

}
