package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ByteArrayResource
 *
 * @author xiaozhou.tu
 * @since 2015-09-25
 */
public class ByteArrayResource extends AbstractResource {

    private final byte[] byteArray;

    public ByteArrayResource(byte[] byteArray) {
        Assert.notNull(byteArray, "Byte array must not be null");
        this.byteArray = byteArray;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.byteArray);
    }

}
