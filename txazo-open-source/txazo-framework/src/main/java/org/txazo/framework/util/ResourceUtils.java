package org.txazo.framework.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public abstract class ResourceUtils {

    public static final String CLASSPATH_URL_PREFIX = "classpath:";
    public static final String FILE_URL_PREFIX = "file:";
    public static final String URL_PROTOCOL_FILE = "file";
    public static final String URL_PROTOCOL_JAR = "jar";
    public static final String URL_PROTOCOL_ZIP = "zip";
    public static final String URL_PROTOCOL_WSJAR = "wsjar";
    public static final String URL_PROTOCOL_VFSZIP = "vfszip";
    public static final String URL_PROTOCOL_VFSFILE = "vfsfile";
    public static final String URL_PROTOCOL_VFS = "vfs";
    public static final String JAR_URL_SEPARATOR = "!/";

    /**
     * toURI
     */
    public static URI toURI(URL url) throws URISyntaxException {
        return toURI(url.toString());
    }

    /**
     * toURI
     */
    public static URI toURI(String location) throws URISyntaxException {
        return new URI(StringUtils.replace(location, " ", "%20"));
    }

    public static boolean isFileURL(URL url) {
        String protocol = url.getProtocol();
        return (URL_PROTOCOL_FILE.equals(protocol) || URL_PROTOCOL_VFSFILE.equals(protocol) ||
                URL_PROTOCOL_VFS.equals(protocol));
    }

    public static File getFile(URL resourceUrl, String description) throws FileNotFoundException {
        Assert.notNull(resourceUrl, "Resource URL must not be null");
        if (!URL_PROTOCOL_FILE.equals(resourceUrl.getProtocol())) {
            throw new FileNotFoundException(
                    description + " cannot be resolved to absolute File");
        }
        try {
            return new File(toURI(resourceUrl).getSchemeSpecificPart());
        } catch (URISyntaxException ex) {
            return new File(resourceUrl.getFile());
        }
    }

    public static void useCachesIfNecessary(URLConnection con) {
        con.setUseCaches(con.getClass().getSimpleName().startsWith("JNLP"));
    }

}

