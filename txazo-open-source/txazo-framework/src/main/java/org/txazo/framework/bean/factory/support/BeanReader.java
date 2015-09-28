package org.txazo.framework.bean.factory.support;

import org.txazo.framework.bean.BeanException;
import org.txazo.framework.core.io.Resource;
import org.txazo.framework.core.io.ResourceLoader;

public interface BeanReader {

    BeanRegistry getRegistry();

    ResourceLoader getResourceLoader();

    int loadBeans(String location) throws BeanException;

    int loadBeans(String... locations) throws BeanException;

    int loadBeans(Resource resource) throws BeanException;

    int loadBeans(Resource... resources) throws BeanException;

}
