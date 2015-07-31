package org.txazo.java.core.lang;

import org.junit.Test;

/**
 * AutoCloseableTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.AutoCloseable
 * @since 27.07.2015
 */
public class AutoCloseableTest {

    /**
     * AutoCloseable
     *
     * 1) try-with-resource语法下自动关闭
     */

    @Test
    public void test() {
        try (Resource resource = new Resource()) {
            resource.load("AutoCloseable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Resource implements AutoCloseable {

        private byte[] data;

        public Resource() {
            data = new byte[1024];
        }

        public void load(String resource) {
            data = resource.getBytes();
        }

        @Override
        public void close() throws Exception {
            data = null;
            System.out.println("Resource closed");
        }

    }

}
