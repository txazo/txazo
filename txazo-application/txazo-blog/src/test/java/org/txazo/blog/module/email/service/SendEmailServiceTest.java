package org.txazo.blog.module.email.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.blog.SpringAbstractTest;

/**
 * SendEmailServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public class SendEmailServiceTest extends SpringAbstractTest {

    @Autowired
    private SendEmailService sendEmailService;

    @Test
    public void testSendValidateEmail() {
        sendEmailService.sendValidateEmail("784990655@qq.com", "123456");
    }

}
