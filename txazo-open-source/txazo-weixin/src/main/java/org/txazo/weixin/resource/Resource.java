package org.txazo.weixin.resource;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Resource
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public interface Resource extends InputStreamSource {

    boolean exists();

    File getFile() throws IOException;

    String getFileName();

    URL getURL() throws IOException;

}
