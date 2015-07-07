package org.txazo.wx.app.user.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public class User implements Serializable {

    private static final long serialVersionUID = -2720815510817400462L;

    /** id */
    private int id;
    /** 用户名 */
    private String userName;
    /** 真实姓名 */
    private String trueName;
    /** 权限 */
    private int privilege;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

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

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
