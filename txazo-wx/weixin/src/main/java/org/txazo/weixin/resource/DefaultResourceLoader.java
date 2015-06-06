package org.txazo.weixin.resource;

import org.txazo.weixin.util.AssertUtils;

/**
 * DefaultResourceLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String path) {
        AssertUtils.assertNotNull(path, "path must not be null");
        if (path.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(path.substring(CLASSPATH_URL_PREFIX.length()));
        }
        return null;
    }

}
