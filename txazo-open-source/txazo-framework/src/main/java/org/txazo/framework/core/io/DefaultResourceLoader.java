package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.ClassUtils;
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

    private ClassLoader classLoader;

    public DefaultResourceLoader() {
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }

    public DefaultResourceLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith("/")) {
            return getResourceByPath(location);
        } else if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()), getClassLoader());
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
        return new ClassPathContextResource(path, getClassLoader());
    }

    protected static class ClassPathContextResource extends ClassPathResource implements ContextResource {

        public ClassPathContextResource(String path, ClassLoader classLoader) {
            super(path, classLoader);
        }

        public String getPathWithinContext() {
            return getPath();
        }

        public Resource createRelative(String relativePath) {
            String newPath = StringUtils.applyRelativePath(getPath(), relativePath);
            return new ClassPathContextResource(newPath, getClassLoader());
        }

    }

}
