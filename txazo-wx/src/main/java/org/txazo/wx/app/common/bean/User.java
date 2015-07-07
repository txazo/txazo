package org.txazo.wx.app.common.bean;

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
    private long privilege;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
