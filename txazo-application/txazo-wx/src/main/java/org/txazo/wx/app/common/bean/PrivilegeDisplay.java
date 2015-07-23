package org.txazo.wx.app.common.bean;

import org.txazo.wx.app.common.enums.PrivilegeType;
import org.txazo.wx.app.common.util.PrivilegeUtils;

import java.io.Serializable;

/**
 * PrivilegeDisplay
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public class PrivilegeDisplay implements Serializable {

    private static final long serialVersionUID = -6660516809114351278L;

    private int privilege;
    private String title;
    private boolean hasPrivilege;

    public PrivilegeDisplay(int userPrivilege, PrivilegeType privilege) {
        this.privilege = privilege.getId();
        this.title = privilege.getTitle();
        this.hasPrivilege = PrivilegeUtils.checkPrivilege(this.privilege, userPrivilege);
    }

    public boolean isHasPrivilege() {
        return hasPrivilege;
    }

    public int getPrivilege() {
        return privilege;
    }

    public String getTitle() {
        return title;
    }

}
