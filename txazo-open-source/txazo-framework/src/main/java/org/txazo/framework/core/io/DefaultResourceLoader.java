package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DefaultResourceLoader
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public class DefaultResourceLoader implements ResourceLoader {

    public DefaultResourceLoader() {
    }

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith("/")) {
            return getResourceByPath(location);
        } else if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return getResourceByPath(location);
            }
        }
    }

    protected Resource getResourceByPath(String path) {
        return new ClassPathContextResource(path);
    }

    protected static class ClassPathContextResource extends ClassPathResource implements ContextResource {

        public ClassPathContextResource(String path) {
            super(path);
        }

        public String getPathWithinContext() {
            return getPath();
        }

        public Resource createRelative(String relativePath) {
            String newPath = StringUtils.applyRelativePath(getPath(), relativePath);
            return new ClassPathContextResource(newPath);
        }

    }

}
