package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.StringUtils;

/**
 * ClassRelativeResourceLoader
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public class ClassRelativeResourceLoader extends DefaultResourceLoader {

    private final Class<?> clazz;

    public ClassRelativeResourceLoader(Class<?> clazz) {
        Assert.notNull(clazz, "Class must not be null");
        this.clazz = clazz;
        setClassLoader(clazz.getClassLoader());
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassRelativeContextResource(path, this.clazz);
    }

    private static class ClassRelativeContextResource extends ClassPathResource implements ContextResource {

        private final Class<?> clazz;

        public ClassRelativeContextResource(String path, Class<?> clazz) {
            super(path, clazz);
            this.clazz = clazz;
        }

        @Override
        public String getPathWithinContext() {
            return getPath();
        }

        @Override
        public Resource createRelative(String relativePath) {
            String newPath = StringUtils.applyRelativePath(getPath(), relativePath);
            return new ClassRelativeContextResource(newPath, this.clazz);
        }

    }

}
