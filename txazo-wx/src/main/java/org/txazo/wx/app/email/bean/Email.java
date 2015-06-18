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
    /** 发件人Email */
    private String fromEmail;
    /** 发件人 */
    private String fromPerson;
    /** 收件人Email */
    private String toEmail;
    /** 收件人 */
    private String toPerson;
    /** 邮件主题 */
    private String subject;
    /** 发送时间 */
    private Date sendTime;
    /** contentId */
    private int contentId;
    /** 附件 */
    private String attachment;
    /** messageId */
    private String messageId;
    /** 创建时间 */
    private Date createTime;

    /** 邮件内容 */
    private EmailContent emailContent;

    public Email() {
    }

    public Email(MimeEmail email) {
        this.fromEmail = email.getFromEmail();
        this.fromPerson = email.getFromPerson();
        this.toEmail = email.getToEmail();
        this.toPerson = email.getToPerson();
        this.subject = email.getSubject();
        this.sendTime = email.getSendTime();
        this.messageId = email.getMessageId();
        this.attachment = email.getAttachment();
        this.emailContent = new EmailContent(email.getContent());
    }

    public String getContent() {
        return emailContent.getContent();
    }

    public void setContent(String content) {
        this.emailContent = new EmailContent(content);
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public EmailContent getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(EmailContent emailContent) {
        this.emailContent = emailContent;
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

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getToPerson() {
        return toPerson;
    }

    public void setToPerson(String toPerson) {
        this.toPerson = toPerson;
    }

}
