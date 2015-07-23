package org.txazo.wx.app.message.bean;

import java.io.Serializable;

/**
 * Message
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.06.2015
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 4800829083919352998L;

    private int id;
    private String account;
    private String title;
    private String content;
    private int type;
    private int showType;
    private String url;
    private String img;

}
