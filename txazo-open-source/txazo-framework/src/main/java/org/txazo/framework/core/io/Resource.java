package org.txazo.framework.core.io;

import java.io.IOException;

/**
 * Resource
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public interface Resource extends InputStreamSource {

    String getDescription();

    Resource createRelative(String relativePath) throws IOException;

}
