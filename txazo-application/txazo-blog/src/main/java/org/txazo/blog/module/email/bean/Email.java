package org.txazo.blog.module.email.bean;

/**
 * Email
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
public class Email {

    private String from;
    private String to;
    private String subject;
    private String content;
    private boolean html;

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

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

}
