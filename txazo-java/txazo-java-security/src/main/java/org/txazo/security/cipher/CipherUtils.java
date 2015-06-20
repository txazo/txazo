package org.txazo.security.cipher;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.security.Key;

/**
 * DESUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.06.2015
 */
public abstract class CipherUtils {

    /**
     * 加密
     *
     * @param algorithm
     * @param key
     * @param plainText
     * @return
     * @throws Exception
     */
    public String encryptHex(String algorithm, Key key, byte[] plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptBytes = cipher.doFinal(plainText);
        return Hex.encodeHexString(encryptBytes);
    }

    /**
     * 解密
     *
     * @param algorithm
     * @param key
     * @param cipherText
     * @return
     * @throws Exception
     */
    public String decryptHex(String algorithm, Key key, byte[] cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptBytes = cipher.doFinal(cipherText);
        return new String(decryptBytes);
    }

}
