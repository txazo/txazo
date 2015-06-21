package org.txazo.security.rsa;

import org.apache.commons.codec.binary.Hex;
import org.txazo.security.cipher.CipherUtils;
import org.txazo.security.key.KeyBuilder;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSAUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public abstract class RSAUtils {

    private static final String RSA = "RSA";

    private static PublicKey getPublicKeyHex(String publicKey) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Hex.decodeHex(publicKey.toCharArray()));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey getPrivateKey(String privateKey) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Hex.decodeHex(privateKey.toCharArray()));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 公钥加密
     *
     * @param publicKey 公钥
     * @param plainText 明文
     * @return
     * @throws Exception
     */
    public static String publicEncryptHex(String publicKey, String plainText) throws Exception {
        return CipherUtils.encryptHex(RSA, getPublicKeyHex(publicKey), plainText);
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
        return CipherUtils.encryptHex(RSA, getPrivateKey(privateKey), plainText);
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
        return CipherUtils.decryptHex(RSA, getPublicKeyHex(publicKey), cipherText);
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
        return CipherUtils.decryptHex(RSA, getPrivateKey(privateKey), cipherText);
    }

    public static void main(String[] args) throws Exception {
        org.txazo.security.key.Key key = KeyBuilder.buildKey(RSA, 512);
        System.out.println(key.getPublicKeyHexString());
        System.out.println(key.getPrivateHexString());
    }

}
