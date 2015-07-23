package org.txazo.weixin.develop.message;

import java.io.Serializable;

/**
 * Message
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class Message implements Serializable {

    private static final long serialVersionUID = 4698404694062986198L;

    /** 成员ID列表 */
    private String touser;
    /** 部门ID列表 */
    private String toparty;
    /** 标签ID列表 */
    private String totag;
    /** 消息类型 */
    private String msgtype;
    /** 企业应用的id */
    private String agentid;
    /** 是否是保密消息 */
    private String safe;

    public Message() {
    }

    public Message(String msgtype) {
        this.msgtype = msgtype;
    }

    public Message(String touser, String toparty, String totag, String msgtype, String agentid, String safe) {
        this.touser = touser;
        this.toparty = toparty;
        this.totag = totag;
        this.msgtype = msgtype;
        this.agentid = agentid;
        this.safe = safe;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

}
