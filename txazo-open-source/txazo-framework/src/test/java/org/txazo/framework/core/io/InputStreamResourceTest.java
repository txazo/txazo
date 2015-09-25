package org.txazo.framework.core.io;

import org.junit.Test;

import java.io.IOException;

/**
 * @see org.txazo.framework.core.io.InputStreamResource
 */
public class InputStreamResourceTest {

    @Test(expected = IllegalStateException.class)
    public void test() throws IOException {
        InputStreamSource source = new InputStreamResource(getClass().getResourceAsStream("."));
        source.getInputStream();
        source.getInputStream();
    }

}
