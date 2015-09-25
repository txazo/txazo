package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamResource
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public class InputStreamResource extends AbstractResource {

    private volatile boolean read = false;
    private final InputStream inputStream;

    public InputStreamResource(InputStream inputStream) {
        Assert.notNull(inputStream, "InputStream must not be null");
        this.inputStream = inputStream;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (this.read) {
            throw new IllegalStateException("InputStream has already been read");
        }
        this.read = true;
        return this.inputStream;
    }

}
