package org.txazo.weixin.develop.jsapi;

import java.io.Serializable;

/**
 * Ticket
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.07.2015
 */
public class Ticket implements Serializable {

    private static final long serialVersionUID = 4960025981875799059L;

    private String ticket;
    private long expires_in;
    private long createTime = System.currentTimeMillis();
    private int errcode;
    private String errmsg;

    public boolean isExpire() {
        return (System.currentTimeMillis() - createTime) >= (expires_in - 60) * 1000;
    }

    public boolean success() {
        return errcode == 0 && "ok".equals(errmsg);
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
