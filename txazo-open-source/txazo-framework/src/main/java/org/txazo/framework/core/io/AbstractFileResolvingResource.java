package org.txazo.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

public class AbstractFileResolvingResource extends AbstractResource {

    public AbstractFileResolvingResource() {
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

}
