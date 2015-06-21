package org.txazo.security.signature;

import org.apache.commons.codec.binary.Hex;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * SignatureUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.06.2015
 */
public abstract class SignatureUtils {

    /**
     * 签名
     *
     * @param algorithm  算法
     * @param privateKey 私钥
     * @param plainText  明文
     * @return
     * @throws Exception
     */
    public static String signHex(String algorithm, PrivateKey privateKey, String plainText) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        signature.update(plainText.getBytes());
        return Hex.encodeHexString(signature.sign());
    }

    /**
     * 验证
     *
     * @param algorithm     算法
     * @param publicKey     公钥
     * @param plainText     明文
     * @param signatureText 签名
     * @return
     * @throws Exception
     */
    public static boolean verifyHex(String algorithm, PublicKey publicKey, String plainText, String signatureText) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(publicKey);
        signature.update(plainText.getBytes());
        return signature.verify(Hex.decodeHex(signatureText.toCharArray()));
    }

}
