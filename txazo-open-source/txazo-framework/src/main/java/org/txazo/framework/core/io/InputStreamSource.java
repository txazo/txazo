package org.txazo.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamSource
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;

}
