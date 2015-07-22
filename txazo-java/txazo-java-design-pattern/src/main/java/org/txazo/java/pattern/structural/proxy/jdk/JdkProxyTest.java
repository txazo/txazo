package org.txazo.java.pattern.structural.proxy.jdk;

import org.junit.Test;
import org.txazo.java.pattern.structural.proxy.IService;
import org.txazo.java.pattern.structural.proxy.IServiceImpl;

/**
 * JdkProxyTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class JdkProxyTest {

    @Test
    public void test() {
        IService iService = new IServiceImpl();
        IService proxy = new JdkProxy<IService>().getProxy(iService);
        proxy.service();
    }

}
