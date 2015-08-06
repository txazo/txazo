package org.txazo.monitor.spring.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * MonitorHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.08.2015
 */
public class MonitorHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        System.out.println("init add monitor");
        registerBeanDefinitionParser("monitor", new MonitorBeanDefinitionParser());
    }

}
