package org.txazo.wx.app.email.service.impl;

import org.springframework.stereotype.Service;
import org.txazo.weixin.util.AssertUtils;
import org.txazo.wx.app.email.bean.Account;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.bean.MimeEmail;
import org.txazo.wx.app.email.service.EmailReceiveService;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * EmailReceiveService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
@Service
public class EmailReceiveServiceImpl implements EmailReceiveService {

    private static final String MAIL_STORE_PROTOCOL = "mail.store.protocol";
    private static final String MAIL_POP3_HOST = "mail.pop3.host";
    private static final String MAIL_POP3_AUTH = "mail.pop3.auth";

    @Override
    public List<Email> receiveEmail(Account account) throws Exception {
        AssertUtils.assertNotNull(account, "account can not be null");

        Store store = getSession(account).getStore();
        store.connect();

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        int end = folder.getMessageCount();
        Message[] messages = folder.getMessages(end - 9, end);

        List<Email> emails = new ArrayList<Email>();
        if (messages != null) {
            Email email = null;
            for (Message message : messages) {
                email = buildEmail((MimeMessage) message);
                if (email != null) {
                    emails.add(email);
                }
            }
        }

        folder.close(false);
        store.close();

        return emails;
    }

    private Session getSession(final Account account) {
        Properties props = new Properties();
        props.setProperty(MAIL_STORE_PROTOCOL, account.getProtocol());
        props.setProperty(MAIL_POP3_HOST, account.getHost());
        props.setProperty(MAIL_POP3_AUTH, account.getAuth());

        return Session.getDefaultInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account.getUser(), account.getPasswd());
            }

        });
    }

    private Email buildEmail(MimeMessage message) {
        try {
            return new Email(new MimeEmail(message));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
