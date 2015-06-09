package org.txazo.weixin.agent;

import org.txazo.weixin.media.MediaUtils;

/**
 * Agent
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public enum Agent {

    AGENT_0("0", "0", "开发社区", "开发社区", "wx.txazo.com", 0, 0),
    AGENT_2("2", "0", "提醒事项", "提醒事项", "wx.txazo.com", 0, 0),
    AGENT_3("3", "0", "生活助手", "生活助手", "wx.txazo.com", 0, 0),
    AGENT_4("4", "0", "邮件系统", "邮件系统", "wx.txazo.com", 0, 0),
    AGENT_5("5", "0", "职业规划", "职业规划", "wx.txazo.com", 0, 0),
    AGENT_6("6", "0", "数据平台", "数据平台", "wx.txazo.com", 0, 0),
    AGENT_7("7", "0", "后台系统", "后台系统", "wx.txazo.com", 0, 0),
    AGENT_8("8", "0", "帮助中心", "帮助中心", "wx.txazo.com", 0, 0);

    static {
        AGENT_0.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_0.jpg"));
        AGENT_2.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_2.jpg"));
        AGENT_3.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_3.jpg"));
        AGENT_4.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_4.jpg"));
        AGENT_5.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_5.jpg"));
        AGENT_6.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_6.jpg"));
        AGENT_7.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_7.jpg"));
        AGENT_8.setLogo_mediaid(MediaUtils.getMediaId("classpath:images/agent_8.jpg"));
    }

    /** 企业应用的id */
    private String agentid;
    /** 企业应用是否打开地理位置上报(0－不上报，1-进入会话上报，2-持续上报) */
    private String report_location_flag;
    /** 企业应用头像的mediaid */
    private String logo_mediaid;
    /** 企业应用名称 */
    private String name;
    /** 企业应用详情 */
    private String description;
    /** 企业应用可信域名 */
    private String redirect_domain;
    /** 是否接收用户变更通知(0－不接受，1－接受) */
    private int isreportuser;
    /** 是否上报用户进入应用事件(0－不接受，1－接受) */
    private int isreportenter;

    Agent(String agentid, String report_location_flag, String name, String description, String redirect_domain, int isreportuser, int isreportenter) {
        this.agentid = agentid;
        this.report_location_flag = report_location_flag;
        this.name = name;
        this.description = description;
        this.redirect_domain = redirect_domain;
        this.isreportuser = isreportuser;
        this.isreportenter = isreportenter;
    }

    public void setLogo_mediaid(String logo_mediaid) {
        this.logo_mediaid = logo_mediaid;
    }

    public String getAgentid() {
        return agentid;
    }

    public String getDescription() {
        return description;
    }

    public int getIsreportenter() {
        return isreportenter;
    }

    public int getIsreportuser() {
        return isreportuser;
    }

    public String getLogo_mediaid() {
        return logo_mediaid;
    }

    public String getName() {
        return name;
    }

    public String getRedirect_domain() {
        return redirect_domain;
    }

    public String getReport_location_flag() {
        return report_location_flag;
    }

}
