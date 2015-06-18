package org.txazo.wx.app.email;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailService;

import java.util.Date;

/**
 * EmailServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public class EmailServiceTest extends SpringAbstractTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testAddEmail() {
        Email email = new Email();
        email.setFrom("txazo1218@163.com");
        email.setTo("784990655@qq.com");
        email.setSubject("邮件主题");
        email.setSendTime(new Date());
        email.setMessageId("messageId");
        email.setContent("邮件内容");
        email.setAttachment("[]");
        Assert.assertTrue(emailService.addEmail(email));
    }

    @Test
    public void testGetEmail() {
        Email email = emailService.getEmail(1);
        Assert.assertNotNull(email);
        Assert.assertNotNull(email.getEmailContent());
    }

}
