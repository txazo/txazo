package org.txazo.wx.menu.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.log.LoggerUtils;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.access.service.AccessTokenService;

/**
 * MenuServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public class MenuServiceTest extends SpringAbstractTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testCreateMenu() {
        menuService.createMenu();
    }

}
