package org.txazo.wx.app.memory.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.txazo.wx.app.memory.enums.MemoryType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Memory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
public class Memory implements Serializable {

    private static final long serialVersionUID = -7325252487897935131L;

    /** id */
    private int id;
    /** 父id */
    private int parentId;
    /** 类型, 1－目录, 2－元素 */
    private int type;
    /** 名称 */
    private String name;
    /** 内容 */
    private String content;
    /** 是否删除, 0－否, 1－是 */
    private int isDeleted;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Timestamp updateTime;

    private ExtContent extContent;

    public ExtContent getExtContent() {
        if (extContent != null) {
            return extContent;
        }
        if (extContent == null) {
            extContent = new ExtContent();
        }
        if (StringUtils.isNotBlank(content)) {
            try {
                JSONObject jsonObject = JSON.parseObject(content);
                if (jsonObject != null) {
                    JSONArray jsonArray = (JSONArray) jsonObject.get("point");
                    String[] arrays = new String[jsonArray.size()];
                    jsonArray.toArray(arrays);
                    extContent.setPoint(arrays);
                }
            } catch (Exception e) {
            }
        }
        return extContent;
    }

    public void setExtContent(ExtContent extContent) {
        if (extContent != null) {
            this.content = JSON.toJSONString(extContent);
        }
        this.extContent = extContent;
    }

    public boolean isTree() {
        return this.type == MemoryType.TREE.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setType(MemoryType type) {
        this.type = type.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
