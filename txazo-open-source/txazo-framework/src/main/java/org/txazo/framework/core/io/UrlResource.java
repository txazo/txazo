package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class UrlResource extends AbstractResource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL can not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        ResourceUtils.useCachesIfNecessary(con);
        try {
            return con.getInputStream();
        } catch (IOException e) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection) con).disconnect();
            }
            throw e;
        }
    }

}
