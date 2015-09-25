package org.txazo.framework.core.io;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.framework.test.InputStreamUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @see org.txazo.framework.core.io.ByteArrayResource
 */
public class ByteArrayResourceTest {

    @Test
    public void test() throws IOException {
        InputStreamSource source = new ByteArrayResource("ByteArrayResource".getBytes());
        InputStream is = source.getInputStream();
        Assert.assertEquals("ByteArrayResource", InputStreamUtils.getString(is));
    }

}
