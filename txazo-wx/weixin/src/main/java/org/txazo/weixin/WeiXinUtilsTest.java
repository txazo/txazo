package org.txazo.weixin;

import org.junit.Test;
import org.txazo.log.LoggerUtils;

/**
 * WeiXinUtilsTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class WeiXinUtilsTest {

    @Test
    public void testGetAccessToken() {
        LoggerUtils.log(WeiXinUtils.getAccessToken());
        LoggerUtils.log(WeiXinUtils.getAccessToken());
    }

    @Test
    public void testGetMediaId() {
        LoggerUtils.log(WeiXinUtils.getMediaId("classpath:images/agent_0.jpg"));
        LoggerUtils.log(WeiXinUtils.getMediaId("classpath:images/agent_0.jpg"));
    }

    @Test
    public void testVerifyURL() {
        LoggerUtils.log(WeiXinUtils.verifyURL("f3feadae32dc8e39ec465e9dbd28daaf1e99f027", "1433914969", "1725123544", "tBvUFIm73NqScxncEM7aVTwJu9Rx4RTrBAAvyX4Ll8aCYS6KOg+7m9gynKyoeac3YBGLcDEioCqtLBQNXE0hQA=="));
    }

}
