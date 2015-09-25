package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.factory.config.BeanDefinition;
import org.txazo.framework.core.io.AbstractResource;
import org.txazo.framework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class BeanDefinitionResource extends AbstractResource {

    private final BeanDefinition beanDefinition;

    public BeanDefinitionResource(BeanDefinition beanDefinition) {
        Assert.notNull(beanDefinition, "BeanDefinition must not be null");
        this.beanDefinition = beanDefinition;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

}
