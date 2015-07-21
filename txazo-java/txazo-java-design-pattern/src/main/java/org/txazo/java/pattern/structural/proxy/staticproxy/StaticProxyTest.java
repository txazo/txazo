package org.txazo.java.pattern.structural.proxy.staticproxy;

import org.junit.Test;
import org.txazo.java.pattern.structural.proxy.IService;
import org.txazo.java.pattern.structural.proxy.IServiceImpl;

/**
 * StaticProxyTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class StaticProxyTest {

    @Test
    public void testInheritanceProxy() {
        IService proxy = new IServiceInheritanceProxy();
        proxy.service();
    }

    @Test
    public void testCompositionProxy() {
        IService iService = new IServiceImpl();
        IService proxy = new IServiceCompositionProxy(iService);
        proxy.service();
    }

}
