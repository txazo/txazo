package org.txazo.java.pattern.structural.proxy.cglib;

import org.junit.Test;
import org.txazo.java.pattern.structural.proxy.IService;
import org.txazo.java.pattern.structural.proxy.IServiceImpl;

/**
 * CGLibProxyTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class CGLibProxyTest {

    @Test
    public void test() {
        IService iService = new IServiceImpl();
        IService proxy = (IService) new CGLibProxy().getProxy(iService);
        proxy.service();
    }

}
