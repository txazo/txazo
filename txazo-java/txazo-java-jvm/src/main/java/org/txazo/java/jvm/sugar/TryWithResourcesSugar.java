package org.txazo.java.jvm.sugar;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * TryWithResourcesSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class TryWithResourcesSugar {

    /**
     * try-with-resources - 语法糖
     */

    @Test
    public void test() {
        try (InputStream is = new FileInputStream("/Users/txazo/t-stop.sh")) {
            is.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecompile() {
        try {
            InputStream is = new FileInputStream("/Users/txazo/t-stop.sh");
            Throwable localThrowable2 = null;
            try {
                is.read();
            } catch (Throwable localThrowable1) {
                localThrowable2 = localThrowable1;
                throw localThrowable1;
            } finally {
                if (is != null) {
                    if (localThrowable2 != null) {
                        try {
                            is.close();
                        } catch (Throwable x2) {
                            localThrowable2.addSuppressed(x2);
                        }
                    } else {
                        is.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
