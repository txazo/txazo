package org.txazo.framework.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * 资源
 * <p/>
 * 1) .xml
 * 2) .class
 */
public interface Resource extends InputStreamSource {

    boolean exists();

    String getFileName();

    URL getURL() throws IOException;

    URI getURI() throws IOException;

    File getFile() throws IOException;

}
