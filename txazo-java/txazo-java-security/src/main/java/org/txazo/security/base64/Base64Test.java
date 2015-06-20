package org.txazo.security.base64;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64Test
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public class Base64Test {

    /**
     * Base64
     * 1. A-Z a-z 0-9 + / =
     * 2. 双向加密
     * 3. 3个8位字节转换为4个8位字节(3 * 8 = 4 * 6，高两位补0)
     */

    /** 明文 */
    private String plainText = "security base64";
    /** 密文 */
    private String cipherText = "c2VjdXJpdHkgYmFzZTY0";

    @Test
    public void testJdkBase64() throws Exception {
        /** JDK Base64 加密 */
        String encryptText = new BASE64Encoder().encode(plainText.getBytes());
        Assert.assertEquals(cipherText, encryptText);
        /** JDK Base64 解密 */
        String decryptText = new String(new BASE64Decoder().decodeBuffer(encryptText));
        Assert.assertEquals(plainText, decryptText);
    }

    @Test
    public void testCodecBase64() {
        /** Commons Codec Base64 加密 */
        String encryptText = Base64.encodeBase64String(plainText.getBytes());
        Assert.assertEquals(cipherText, encryptText);
        /** Commons Codec Base64 解密 */
        String decryptText = new String(Base64.decodeBase64(encryptText));
        Assert.assertEquals(plainText, decryptText);
    }

}
