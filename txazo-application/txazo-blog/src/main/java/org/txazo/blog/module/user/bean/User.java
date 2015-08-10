package org.txazo.blog.module.user.bean;

import java.io.Serializable;

/**
 * 用户
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class User implements Serializable {

    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
