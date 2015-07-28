package org.txazo.java.io;

import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;

/**
 * CloseableTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.io.Closeable
 * @since 27.07.2015
 */
public class CloseableTest {

    /**
     * Closeable
     * <pre>
     * 1) 可以关闭的资源
     * 2) 调用close()释放资源
     * 3) 常见的实现类有:
     *    InputStream OutputStream
     *    Reader Writer
     *    Socket ServerSocket
     * </pre>
     */

    @Test
    public void test() {
        Resource resource = null;
        try {
            resource = new Resource();
        } finally {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private class Resource implements Closeable {

        private byte[] data;

        private Resource() {
            data = new byte[1024];
        }

        @Override
        public void close() throws IOException {
            data = null;
            System.out.println("Resource closed");
        }

    }

}
