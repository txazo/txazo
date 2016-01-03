package org.txazo.nio.reactor.server.encode;

import javax.crypto.Cipher;
import java.security.Key;

public abstract class CipherUtils {

    public static byte[] encrypt(String algorithm, Key key, byte[] data) throws Exception {
        return cipher(Cipher.ENCRYPT_MODE, algorithm, key, data);
    }

    public static byte[] decrypt(String algorithm, Key key, byte[] data) throws Exception {
        return cipher(Cipher.DECRYPT_MODE, algorithm, key, data);
    }

    public static byte[] cipher(int mode, String algorithm, Key key, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(mode, key);
        return cipher.doFinal(data);
    }

}
