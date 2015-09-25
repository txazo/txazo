package org.txazo.framework.core.io;

import org.txazo.framework.util.ResourceUtils;

/**
 * ResourceLoader
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;

    Resource getResource(String location);

}
