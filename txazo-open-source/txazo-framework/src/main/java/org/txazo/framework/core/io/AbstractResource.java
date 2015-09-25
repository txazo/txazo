package org.txazo.framework.core.io;

import java.io.IOException;

/**
 * AbstractResource
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public abstract class AbstractResource implements Resource {

    public AbstractResource() {
    }

    @Override
    public Resource createRelative(String relativePath) throws IOException {
        throw new IOException("Cannot create a relative resource");
    }

}
