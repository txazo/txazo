package org.txazo.weixin.resource;

/**
 * ResourceLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String path);

}
