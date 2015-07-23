package org.txazo.wx.app.email.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * EmailContent
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public class EmailContent implements Serializable {

    private static final long serialVersionUID = -8318507515475326823L;

    /** ID */
    private int id;
    /** 邮件内容 */
    private String content;
    /** 创建时间 */
    private Date createTime;

    public EmailContent() {
    }

    public EmailContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
