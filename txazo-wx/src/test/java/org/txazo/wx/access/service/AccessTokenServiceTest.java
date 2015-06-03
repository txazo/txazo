package org.txazo.wx.access.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.log.LoggerUtils;
import org.txazo.wx.SpringAbstractTest;

/**
 * AccessTokenServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public class AccessTokenServiceTest extends SpringAbstractTest {

    @Autowired
    private AccessTokenService accessTokenService;

    @Test
    public void testGetAccessToken() {
        LoggerUtils.log(accessTokenService.getAccessToken());
    }

}
