package org.txazo.weixin.resource;

import org.txazo.weixin.util.AssertUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * ClassPathResource
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class ClassPathResource extends AbstractResource {

    private final String path;

    public ClassPathResource(String path) {
        AssertUtils.assertNotNull(path, "path must not be null");
        this.path = path;
    }

    @Override
    public boolean exists() {
        return this.resolveURL() != null;
    }

    private URL resolveURL() {
        return ClassLoader.getSystemResource(this.path);
    }

    @Override
    public File getFile() throws IOException {
        return new File(this.getURL().getFile());
    }

    @Override
    public String getFileName() {
        if (this.path == null) {
            return null;
        }
        int index = this.path.lastIndexOf("/");
        return index != -1 ? this.path.substring(index + 1) : this.path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream(this.path);
        if (is == null) {
            throw new FileNotFoundException("stream can not be open");
        }
        return is;
    }

    @Override
    public URL getURL() throws IOException {
        URL url = this.resolveURL();
        if (url == null) {
            throw new FileNotFoundException("url not exists");
        }
        return url;
    }

}
