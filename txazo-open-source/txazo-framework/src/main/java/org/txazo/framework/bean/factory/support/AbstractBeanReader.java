package org.txazo.framework.bean.factory.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.txazo.framework.bean.BeanException;
import org.txazo.framework.core.io.Resource;
import org.txazo.framework.core.io.ResourceLoader;
import org.txazo.framework.util.Assert;

public abstract class AbstractBeanReader implements BeanReader {

    private static final Logger logger = LoggerFactory.getLogger(AbstractBeanReader.class);

    private final BeanRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanReader(BeanRegistry registry) {
        this.registry = registry;
    }

    @Override
    public BeanRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public int loadBeans(String location) throws BeanException {
        return loadBeans(new String[]{location});
    }

    @Override
    public int loadBeans(String... locations) throws BeanException {
        Assert.notNull(locations, "Location array must not be null");
        int counter = 0;
        for (String location : locations) {
            counter += loadBeans(location);
        }
        return counter;
    }

    @Override
    public int loadBeans(Resource... resources) throws BeanException {
        Assert.notNull(resources, "Resource array must not be null");
        int counter = 0;
        for (Resource resource : resources) {
            counter += loadBeans(resource);
        }
        return counter;
    }

}
