package org.txazo.weixin.develop.agent;

import java.io.Serializable;

/**
 * AgentList
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.07.2015
 */
public class AgentList implements Serializable {

    private static final long serialVersionUID = 1989894575653310502L;

    /** 应用id */
    private String agentid;
    /** 应用名称 */
    private String name;
    /** 方形头像url */
    private String square_logo_url;
    /** 圆形头像url */
    private String round_logo_url;

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRound_logo_url() {
        return round_logo_url;
    }

    public void setRound_logo_url(String round_logo_url) {
        this.round_logo_url = round_logo_url;
    }

    public String getSquare_logo_url() {
        return square_logo_url;
    }

    public void setSquare_logo_url(String square_logo_url) {
        this.square_logo_url = square_logo_url;
    }

}
