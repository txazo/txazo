package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.StringUtils;

import java.io.*;

/**
 * FileSystemResource
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public class FileSystemResource extends AbstractResource {

    private final File file;
    private final String path;

    public FileSystemResource(File file) {
        Assert.notNull(file, "File must not be null");
        this.file = file;
        this.path = StringUtils.cleanPath(file.getPath());
    }

    public FileSystemResource(String path) {
        Assert.notNull(path, "Path must not be null");
        this.file = new File(path);
        this.path = StringUtils.cleanPath(path);
    }

    public final String getPath() {
        return this.path;
    }

    @Override
    public String getDescription() {
        return this.file.getAbsolutePath();
    }

    @Override
    public Resource createRelative(String relativePath) {
        String newPath = StringUtils.applyRelativePath(this.path, relativePath);
        return new FileSystemResource(newPath);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

}
