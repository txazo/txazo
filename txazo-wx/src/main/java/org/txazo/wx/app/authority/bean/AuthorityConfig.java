package org.txazo.wx.app.authority.bean;

import java.io.Serializable;

/**
 * AuthorityConfig
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.07.2015
 */
public class AuthorityConfig implements Serializable {

    private static final long serialVersionUID = 7885579526704300885L;

    private int appId;
    private String name;
    private String image;
    private int write;
    private int read;

}
