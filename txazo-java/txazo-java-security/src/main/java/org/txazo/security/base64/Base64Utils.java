package org.txazo.security.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Base64Utils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public abstract class Base64Utils {

    public static byte[] decode(String key) throws IOException {
        return new BASE64Decoder().decodeBuffer(key);
    }

    public static String encode(byte[] key) {
        return new BASE64Encoder().encodeBuffer(key);
    }

}
