package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.ResourceUtils;
import org.txazo.framework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class UrlResource extends AbstractFileResolvingResource {

    private final URI url;

    public UrlResource(String path) throws MalformedURLException {
        Assert.notNull(path, "Path must not be null");
        this.uri = null;
        this.url = new URL(path);
        this.cleanedUrl = this.getCleanedUrl(this.url, path);
    }

    public UrlResource(String path){

    }

    private URL getCleanedUrl(URL url) {
        this.url = url;
    }

    @Override
    public String getDescription() {
        return this.url.toString();
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
