package org.txazo.weixin.config;

import org.txazo.weixin.resource.Resource;

/**
 * BeanDefinitionReader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public interface BeanDefinitionReader {

    int loadBeanDefinitions(Resource resource) throws BeanDefinitionException;

    int loadBeanDefinitions(Resource... resources) throws BeanDefinitionException;

    int loadBeanDefinitions(String path) throws BeanDefinitionException;

    int loadBeanDefinitions(String... paths) throws BeanDefinitionException;


}
