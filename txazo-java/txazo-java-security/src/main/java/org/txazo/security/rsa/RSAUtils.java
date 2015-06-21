package org.txazo.security.rsa;

import org.txazo.security.cipher.CipherUtils;
import org.txazo.security.key.KeyBuilder;

/**
 * RSAUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public abstract class RSAUtils {

    private static final String RSA = "RSA";

    /**
     * 公钥加密
     *
     * @param publicKey 公钥
     * @param plainText 明文
     * @return
     * @throws Exception
     */
    public static String publicEncryptHex(String publicKey, String plainText) throws Exception {
        return CipherUtils.encryptHex(RSA, KeyBuilder.getPublicKeyHex(RSA, publicKey), plainText);
    }

    /**
     * 私钥加密
     *
     * @param privateKey 私钥
     * @param plainText  明文
     * @return
     * @throws Exception
     */
    public static String privateEncryptHex(String privateKey, String plainText) throws Exception {
        return CipherUtils.encryptHex(RSA, KeyBuilder.getPrivateKeyHex(RSA, privateKey), plainText);
    }

    /**
     * 公钥解密
     *
     * @param publicKey  公钥
     * @param cipherText 密文
     * @return
     * @throws Exception
     */
    public static String publicDecryptHex(String publicKey, String cipherText) throws Exception {
        return CipherUtils.decryptHex(RSA, KeyBuilder.getPublicKeyHex(RSA, publicKey), cipherText);
    }

    /**
     * 私钥解密
     *
     * @param privateKey 私钥
     * @param cipherText 密文
     * @return
     * @throws Exception
     */
    public static String privateDecryptHex(String privateKey, String cipherText) throws Exception {
        return CipherUtils.decryptHex(RSA, KeyBuilder.getPrivateKeyHex(RSA, privateKey), cipherText);
    }

    public static void main(String[] args) throws Exception {
        org.txazo.security.key.Key key = KeyBuilder.buildKey(RSA, 512);
        System.out.println(key.getPublicKeyHexString());
        System.out.println(key.getPrivateHexString());
    }

}
