package org.txazo.weixin.agent;

/**
 * Agent
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public enum Agent {

    AGENT_0("0", "0", "1Fsf1JSfESzv2bDtiaQoi59J-RasfysootIvQ6R9m3N91Gk-FTo7MgBCnp76HFmBn", "开发社区", "开发社区", "wx.txazo.com", 0, 0),
    AGENT_2("2", "0", "1GqqFaB8zS_2NeKRbHtgTsnifFDu-CwR0hDYow0Zm1nAzL-ELQQ-i6tgWHC9XBa6B", "生活小助手", "生活小助手", "wx.txazo.com", 0, 0),
    AGENT_3("3", "0", "", "开发社区", "开发社区", "wx.txazo.com", 0, 0),
    AGENT_4("4", "0", "1AZNg0AZMFSVr-GsTVJtZJujfe5FiO5UPkL-OdmDtIvQiPlOJO8EV7Ze1YUEA74Qs", "邮件系统", "邮件系统", "wx.txazo.com", 0, 0),
    AGENT_5("5", "0", "", "开发社区", "开发社区", "wx.txazo.com", 0, 0),
    AGENT_6("6", "0", "", "开发社区", "开发社区", "wx.txazo.com", 0, 0),
    AGENT_7("7", "0", "", "开发社区", "开发社区", "wx.txazo.com", 0, 0),
    AGENT_8("8", "0", "", "开发社区", "开发社区", "wx.txazo.com", 0, 0);

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

    Agent(String agentid, String report_location_flag, String logo_mediaid, String name, String description, String redirect_domain, int isreportuser, int isreportenter) {
        this.agentid = agentid;
        this.report_location_flag = report_location_flag;
        this.logo_mediaid = logo_mediaid;
        this.name = name;
        this.description = description;
        this.redirect_domain = redirect_domain;
        this.isreportuser = isreportuser;
        this.isreportenter = isreportenter;
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
