package org.txazo.wx.weixin.agent;

/**
 * Agent
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public enum Agent {

    AGENT_0(0, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_2(2, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_3(3, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_4(4, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_5(5, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_6(6, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_7(7, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0),
    AGENT_8(8, 0, 0, "开发社区", "开发社区", "wx.txazo.com ", 0, 0);

    /** 企业应用的id */
    private int agentid;
    /** 企业应用是否打开地理位置上报(0－不上报，1-进入会话上报，2-持续上报) */
    private int report_location_flag;
    /** 企业应用头像的mediaid */
    private int logo_mediaid;
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

    Agent(int agentid, int report_location_flag, int logo_mediaid, String name, String description, String redirect_domain, int isreportuser, int isreportenter) {
        this.agentid = agentid;
        this.report_location_flag = report_location_flag;
        this.logo_mediaid = logo_mediaid;
        this.name = name;
        this.description = description;
        this.redirect_domain = redirect_domain;
        this.isreportuser = isreportuser;
        this.isreportenter = isreportenter;
    }

}
