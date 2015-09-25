package org.txazo.framework.core.io;

/**
 * FileSystemResourceLoader
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public class FileSystemResourceLoader extends DefaultResourceLoader {

    @Override
    protected Resource getResourceByPath(String path) {
        if (path != null && path.startsWith("/")) {
            path = path.substring(1);
        }
        return new FileSystemContextResource(path);
    }

    private static class FileSystemContextResource extends FileSystemResource implements ContextResource {

        public FileSystemContextResource(String path) {
            super(path);
        }

        @Override
        public String getPathWithinContext() {
            return getPath();
        }

    }

}
