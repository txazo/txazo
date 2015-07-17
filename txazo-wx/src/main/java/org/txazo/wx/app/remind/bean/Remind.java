package org.txazo.wx.app.remind.bean;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Remind - 提醒事项
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class Remind implements Serializable {

    private static final long serialVersionUID = 9039470282185415874L;

    /** id */
    private int id;
    /** 用户名 */
    private String userName;
    /** 类型 */
    private int type;
    /** 扩展json */
    private String extJson;
    /** 扩展 */
    private RemindExt ext;
    /** 状态, 0－启用, 1－停用 */
    private int status;
    /** 是否删除, 0－否, 1－是 */
    private int isDeleted;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public Remind() {
    }

    public Remind(int id) {
        this.id = id;
    }

    public RemindExt getExt() {
        if (ext != null) {
            return ext;
        }
        if (StringUtils.isNoneBlank(extJson)) {
            try {
                ext = JSON.parseObject(extJson, RemindExt.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ext == null) {
            ext = new RemindExt();
        }
        return ext;
    }

    public void setExt(RemindExt ext) {
        if (ext != null) {
            extJson = JSON.toJSONString(ext);
        }
        this.ext = ext;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
