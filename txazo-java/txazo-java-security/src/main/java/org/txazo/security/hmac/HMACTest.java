package org.txazo.security.hmac;

import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * HMACTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public class HMACTest {

    /** 明文 */
    private String plainText = "security hmac";
    /** 密文 */
    private String cipherText = "ea8156a8e02f21eedb5828a8017a0ed8";
    /** 密钥 */
    private String secretKey = "hmac_key";

    @Test
    public void testJdkHmacMD5() throws Exception {
        String encryptText = HMACUtils.hmacHex(HmacAlgorithm.HMAC_MD5, secretKey.getBytes(), plainText.getBytes());
        Assert.assertEquals(cipherText, encryptText);
    }

    @Test
    public void testCodecHmacMD5() {
        String encryptText = HmacUtils.hmacMd5Hex(secretKey, plainText);
        Assert.assertEquals(cipherText, encryptText);
    }

}
