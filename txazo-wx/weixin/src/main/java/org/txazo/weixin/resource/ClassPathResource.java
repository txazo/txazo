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
        AssertUtils.assertNotNull(path);
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
        return super.getFileName();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
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
