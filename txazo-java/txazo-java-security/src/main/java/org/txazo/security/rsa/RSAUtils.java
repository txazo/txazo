package org.txazo.security.rsa;

import org.txazo.security.base64.Base64Utils;
import org.txazo.security.key.Algorithm;
import org.txazo.security.key.Key;
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

    public static String sign(byte[] data, String privateKey) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64Utils.decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance(Algorithm.RSA);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(Algorithm.MD5_WITH_RSA);
        signature.initSign(key);
        signature.update(data);
        return Base64Utils.encode(signature.sign());
    }

    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Utils.decode(publicKey));
        KeyFactory keyFactory = KeyFactory.getInstance(Algorithm.RSA);
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(Algorithm.MD5_WITH_RSA);
        signature.initVerify(key);
        signature.update(data);
        return signature.verify(Base64Utils.decode(sign));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Key key = KeyBuilder.buildKey("RSA");
        System.out.println(key.getPublic());
        System.out.println(key.getPrivate());
    }

}
