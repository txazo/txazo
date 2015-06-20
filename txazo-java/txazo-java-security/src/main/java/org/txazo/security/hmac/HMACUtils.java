package org.txazo.security.hmac;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * HMACUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public abstract class HMACUtils {

    /**
     * HMAC加密
     *
     * @param algorithm 算法
     * @param secretKey 密钥
     * @param plainText 明文
     * @return
     * @throws Exception
     */
    public static String hmacHex(HmacAlgorithm algorithm, byte[] secretKey, byte[] plainText) throws Exception {
        Key key = new SecretKeySpec(secretKey, algorithm.getAlgorithm());
        Mac mac = Mac.getInstance(algorithm.getAlgorithm());
        mac.init(key);
        byte[] hmacBytes = mac.doFinal(plainText);
        return Hex.encodeHexString(hmacBytes);
    }

}
