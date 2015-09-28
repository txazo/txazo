package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.factory.config.Bean;
import org.txazo.framework.core.io.AbstractResource;
import org.txazo.framework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class BeanResource extends AbstractResource {

    private final Bean bean;

    public BeanResource(Bean bean) {
        Assert.notNull(bean, "Bean must not be null");
        this.bean = bean;
    }

    public final Bean getBean() {
        return bean;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        throw new IOException("Resource can not be open");
    }

}
