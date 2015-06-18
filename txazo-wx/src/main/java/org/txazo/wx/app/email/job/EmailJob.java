package org.txazo.wx.app.email.job;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.txazo.wx.app.email.EmailReceiver;
import org.txazo.wx.app.email.EmailReminder;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailService;

import java.util.ArrayList;
import java.util.List;

/**
 * EmailJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
@Component
public class EmailJob {

    @Autowired
    private EmailReceiver emailReceiver;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailReminder emailReminder;

    public void execute() {
        List<Email> emails = emailReceiver.receiveEmail();
        List<Email> newEmails = new ArrayList<Email>();
        if (CollectionUtils.isNotEmpty(emails)) {
            for (Email email : emails) {
                if (emailService.addEmail(email)) {
                    newEmails.add(email);
                }
            }
        }
        emailReminder.sendEmailRemind(newEmails);
    }

}
