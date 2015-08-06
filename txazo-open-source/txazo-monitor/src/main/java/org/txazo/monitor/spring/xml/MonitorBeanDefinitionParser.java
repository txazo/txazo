package org.txazo.monitor.spring.xml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * MonitorBeanDefinitionParser
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.08.2015
 */
public class MonitorBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Monitor.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        System.out.println("doParse");
    }

}
