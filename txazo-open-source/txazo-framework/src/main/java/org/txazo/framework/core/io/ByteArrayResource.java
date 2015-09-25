package org.txazo.framework.core.io;

import org.txazo.framework.util.Assert;
import org.txazo.framework.util.StringUtils;

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
    private final String description;

    public ByteArrayResource(byte[] byteArray) {
        this(byteArray, "ByteArrayResource");
    }

    public ByteArrayResource(byte[] byteArray, String description) {
        Assert.notNull(byteArray, "Byte array must not be null");
        this.byteArray = byteArray;
        this.description = description != null ? description : StringUtils.EMPTY;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.byteArray);
    }

}
