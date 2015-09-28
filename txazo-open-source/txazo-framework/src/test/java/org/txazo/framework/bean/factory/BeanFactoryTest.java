package org.txazo.framework.bean.factory;

import org.junit.Test;
import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.bean.factory.config.BeanSource;
import org.txazo.framework.bean.factory.support.BeanBuilder;

public class BeanFactoryTest {

    @Test
    public void test() {
        RegistryBeanFactory beanFactory = new RegistryBeanFactory();

        Bean bean = BeanBuilder.genericBean("txazo", String.class, BeanSource.XML).getBean();

        beanFactory.registerBean(bean);

        beanFactory.getBean("txazo");
        beanFactory.getBean("txazo", String.class);
        beanFactory.getBean(String.class);
        beanFactory.getBean(String.class);
        beanFactory.containsBean("txazo");
        beanFactory.containsBean(String.class);
        beanFactory.getType("txazo");
        beanFactory.getNames(String.class);

        beanFactory.getBean("txazo", Integer.class);
    }

}
