package org.txazo.monitor.spring.xml;

import java.io.Serializable;

/**
 * Monitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.08.2015
 */
public class Monitor implements Serializable {

    private static final long serialVersionUID = 8365937912087700274L;

    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
