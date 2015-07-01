package org.txazo.wx.app.memory.bean;

import java.io.Serializable;

/**
 * Content
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 01.07.2015
 */
public class ExtContent implements Serializable {

    private static final long serialVersionUID = 144738937062714753L;

    private String[] point;

    public String[] getPoint() {
        return point;
    }

    public void setPoint(String[] point) {
        this.point = point;
    }

}
