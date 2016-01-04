package org.txazo.nio.reactor.server.encode;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public abstract class AESUtils {

    private static final String AES = "AES";

    private static Key generateKey(byte[] key) throws Exception {
        return new SecretKeySpec(key, AES);
    }

    public static byte[] encrypt(byte[] key, byte[] data) throws Exception {
        return CipherUtils.encrypt(AES, generateKey(key), data);
    }

    public static byte[] decrypt(byte[] key, byte[] data) throws Exception {
        return CipherUtils.decrypt(AES, generateKey(key), data);
    }

}
