package org.txazo.wx.app.email.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Email
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
public class Email implements Serializable {

    private static final long serialVersionUID = -7973406313524794859L;

    private int id;
    private String from;
    private String to;
    private String subject;
    private Date sendTime;
    private String messageId;
    private String attachment;
    private String content;

    public Email(MimeEmail email) {
        this.from = email.getFrom();
        this.to = email.getTo();
        this.subject = email.getSubject();
        this.sendTime = email.getSendTime();
        this.messageId = email.getMessageId();
        this.attachment = email.getAttachment();
        this.content = email.getContent();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
