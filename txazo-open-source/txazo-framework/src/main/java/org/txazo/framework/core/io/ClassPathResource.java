package org.txazo.framework.core.io;

import org.txazo.framework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource extends AbstractResource {

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = getClass().getResourceAsStream(this.path);
        if (is == null) {
            throw new IOException();
        }
        return is;
    }

    @Override
    public Resource createRelative(String relativePath) {
        String newPath = StringUtils.applyRelativePath(this.path, relativePath);
        return new ClassPathResource(newPath);
    }

}
