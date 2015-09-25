package org.txazo.framework.core.io;

public class FileSystemResourceLoader extends DefaultResourceLoader {

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
