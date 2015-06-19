package org.txazo.wx.app.email.bean;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MimeEmail
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.06.2015
 */
public class MimeEmail {

    private MimeMessage message;

    private String messageId;
    private String fromEmail;
    private String fromPerson;
    private String toEmail;
    private String toPerson;
    private Date sendTime;
    private String subject;
    private StringBuilder content = new StringBuilder();
    private List<String> attachments = new ArrayList<String>();

    public MimeEmail(MimeMessage message) throws Exception {
        this.message = message;
        build();
    }

    private void build() throws Exception {
        this.messageId = message.getMessageID();
        this.fromEmail = getEmail((InternetAddress[]) message.getFrom());
        this.fromPerson = getPerson((InternetAddress[]) message.getFrom());
        this.toEmail = getEmail((InternetAddress[]) message.getRecipients(Message.RecipientType.TO));
        this.toPerson = getPerson((InternetAddress[]) message.getRecipients(Message.RecipientType.TO));
        this.sendTime = message.getSentDate();
        this.subject = MimeUtility.decodeText(message.getSubject()).replaceAll("\\s*", "");
        parsePart(message);
    }

    private String getEmail(InternetAddress[] addresses) throws UnsupportedEncodingException {
        if (ArrayUtils.isEmpty(addresses)) {
            return null;
        }
        return decodeText(addresses[0].getAddress());
    }

    private String getPerson(InternetAddress[] addresses) throws UnsupportedEncodingException {
        if (ArrayUtils.isEmpty(addresses)) {
            return null;
        }
        return decodeText(addresses[0].getPersonal());
    }

    private String decodeText(String text) throws UnsupportedEncodingException {
        return StringUtils.isNotBlank(text) ? MimeUtility.decodeText(text).replaceAll("\\s*", "") : text;
    }

    private void parsePart(Part part) throws Exception {
        if (part.isMimeType("text/*")) {
            content.append((String) part.getContent());
        } else if (part.isMimeType("multipart/*")) {
            Part p = null;
            Multipart multipart = (Multipart) part.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                p = multipart.getBodyPart(i);
                String disposition = p.getDisposition();
                if (disposition != null && (disposition.equals(Part.ATTACHMENT) || disposition.equals(Part.INLINE))) {
                    attachments.add(MimeUtility.decodeText(p.getFileName()));
                }
                parsePart(p);
            }
        } else if (part.isMimeType("message/rfc822")) {
            parsePart((Part) part.getContent());
        }
    }

    public String getAttachment() {
        return JSONArray.toJSONString(attachments);
    }

    public String getContent() {
        return content.toString();
    }

    public String getMessageId() {
        return messageId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public String getSubject() {
        return subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getToPerson() {
        return toPerson;
    }

}
