package org.txazo.weixin.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamSource
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;

}
