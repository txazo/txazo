package org.txazo.framework.bean.factory;

import org.junit.Test;
import org.txazo.framework.bean.Bean;
import org.txazo.framework.bean.BeanSource;

public class BeanFactoryTest {

    @Test
    public void test() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        Bean bean = new Bean();
        bean.setBeanName("txazo");
        bean.setBeanClass(String.class);
        bean.setBeanSource(BeanSource.XML);
        bean.setValue(new String());

        beanFactory.registerBean(bean);

        beanFactory.getBean("txazo");
        beanFactory.getBean("txazo", String.class);
        beanFactory.getBean(String.class);
        beanFactory.getBean(String.class);
        beanFactory.containsBean("txazo");
        beanFactory.containsBean(String.class);
        beanFactory.getType("txazo");
        beanFactory.getName(String.class);

        beanFactory.getBean("txazo", Integer.class);
    }

}
