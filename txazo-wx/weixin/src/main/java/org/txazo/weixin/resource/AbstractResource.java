package org.txazo.weixin.resource;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * AbstractResource
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public abstract class AbstractResource implements Resource {

    @Override
    public boolean exists() {
        try {
            return this.getFile().exists();
        } catch (IOException e) {
            try {
                InputStream is = this.getInputStream();
                IOUtils.closeQuietly(is);
                return true;
            } catch (Throwable t) {
                return false;
            }
        }
    }

    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException("url not exists");
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException("file not exists");
    }

}
