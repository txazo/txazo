package org.txazo.wx.app.email.service.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.txazo.weixin.util.AssertUtils;
import org.txazo.wx.app.email.bean.Account;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * EmailServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
@Service
public class EmailServiceImpl implements EmailService {

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
            Email email = new Email();
            email.setTitle(MimeUtility.decodeText(message.getSubject()));
            email.setFrom(getAddress((InternetAddress[]) message.getFrom()));
            email.setTo(getAddress((InternetAddress[]) message.getRecipients(Message.RecipientType.TO)));
            email.setSendTime(message.getSentDate());
            email.setMessageId(message.getMessageID());
            email.setContent("");
            return email;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getAddress(InternetAddress[] addresses) throws UnsupportedEncodingException {
        if (ArrayUtils.isEmpty(addresses)) {
            return null;
        }
        String personal = addresses[0].getPersonal();
        String address = addresses[0].getAddress();
        address = address != null ? MimeUtility.decodeText(address) : address;
        return StringUtils.isBlank(personal) ? address : MimeUtility.decodeText(personal) + "<" + address + ">";
    }

}
