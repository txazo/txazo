package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.Bean;
import org.txazo.framework.core.io.AbstractResource;
import org.txazo.framework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class BeanDefinitionResource extends AbstractResource {

    private final Bean beanDefinition;

    public BeanDefinitionResource(Bean beanDefinition) {
        Assert.notNull(beanDefinition, "Bean must not be null");
        this.beanDefinition = beanDefinition;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

}
