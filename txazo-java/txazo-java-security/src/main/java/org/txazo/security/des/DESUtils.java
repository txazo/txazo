package org.txazo.security.des;

import org.apache.commons.codec.binary.Hex;
import org.txazo.security.cipher.CipherUtils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;

/**
 * DESUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public abstract class DESUtils {

    private static final String DES = "DES";

    private static Key generateKey(byte[] key) throws Exception {
        KeySpec keySpec = new DESKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(DES);
        return factory.generateSecret(keySpec);
    }

    /**
     * DES加密
     *
     * @param secretKey 密钥
     * @param plainText 明文
     * @return
     * @throws Exception
     */
    public static String encryptHex(String secretKey, String plainText) throws Exception {
        return encryptHex(Hex.decodeHex(secretKey.toCharArray()), plainText.getBytes());
    }

    /**
     * DES加密
     *
     * @param secretBytes 密钥
     * @param plainBytes  明文
     * @return
     * @throws Exception
     */
    public static String encryptHex(byte[] secretBytes, byte[] plainBytes) throws Exception {
        return CipherUtils.encryptHex(DES, generateKey(secretBytes), plainBytes);
    }

    /**
     * DES解密
     *
     * @param secretKey  密钥
     * @param cipherText 密文
     * @return
     * @throws Exception
     */
    public static String decryptHex(String secretKey, String cipherText) throws Exception {
        return decryptHex(Hex.decodeHex(secretKey.toCharArray()), cipherText);
    }

    /**
     * DES解密
     *
     * @param secretBytes 密钥
     * @param cipherText  密文
     * @return
     * @throws Exception
     */
    public static String decryptHex(byte[] secretBytes, String cipherText) throws Exception {
        return CipherUtils.decryptHex(DES, generateKey(secretBytes), cipherText);
    }

}
