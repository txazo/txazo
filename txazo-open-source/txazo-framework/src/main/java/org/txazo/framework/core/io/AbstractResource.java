package org.txazo.framework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public abstract class AbstractResource implements Resource {

    public AbstractResource() {
    }

    @Override
    public boolean exists() {
        try {
            return this.getFile().exists();
        } catch (IOException e) {
            try {
                InputStream is = this.getInputStream();
                is.close();
                return true;
            } catch (Throwable t) {
                return false;
            }
        }
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

}
