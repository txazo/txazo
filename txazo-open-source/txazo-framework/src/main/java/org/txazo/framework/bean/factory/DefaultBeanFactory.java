package org.txazo.framework.bean.factory;

import org.txazo.framework.bean.Bean;
import org.txazo.framework.bean.BeanRegister;
import org.txazo.framework.bean.BeanUtils;

public class DefaultBeanFactory extends AbstractBeanFactory implements BeanRegister {

    @Override
    public void registerBean(Bean bean) {
        BeanUtils.checkBean(bean);
    }

}
