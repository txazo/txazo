package org.txazo.wx.app.email;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailService;

import java.util.List;

/**
 * EmailReceiverTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
public class EmailReceiverTest extends SpringAbstractTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailReceiver emailReceiver;

    @Test
    public void testReceiveEmail() {
        List<Email> emails = emailReceiver.receiveEmail();
        if (CollectionUtils.isNotEmpty(emails)) {
            for (Email email : emails) {
                emailService.addEmail(email);
            }
        }
    }

}
