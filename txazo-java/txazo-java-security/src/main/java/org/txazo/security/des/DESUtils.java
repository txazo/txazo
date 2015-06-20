package org.txazo.security.des;

import org.apache.commons.codec.binary.Hex;
import org.txazo.security.key.KeyBuilder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
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

    public String generateKeyHex() throws NoSuchAlgorithmException {
        return KeyBuilder.buildSecretKeyHexString(DES);
    }

    private Key generateKey(byte[] key) throws Exception {
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
    public String encryptHex(byte[] secretKey, byte[] plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.ENCRYPT_MODE, generateKey(secretKey));
        byte[] encryptBytes = cipher.doFinal(plainText);
        return Hex.encodeHexString(encryptBytes);
    }

    /**
     * DES解密
     *
     * @param secretKey  密钥
     * @param cipherText 密文
     * @return
     * @throws Exception
     */
    public String decryptHex(byte[] secretKey, byte[] cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.DECRYPT_MODE, generateKey(secretKey));
        byte[] decryptBytes = cipher.doFinal(cipherText);
        return new String(decryptBytes);
    }

}
