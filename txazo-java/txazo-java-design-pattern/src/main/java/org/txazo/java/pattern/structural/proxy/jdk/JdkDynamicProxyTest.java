package org.txazo.java.pattern.structural.proxy.jdk;

import org.junit.Test;
import org.txazo.java.pattern.structural.proxy.IService;
import org.txazo.java.pattern.structural.proxy.IServiceImpl;

/**
 * JdkDynamicProxy - JDK动态代理
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class JdkDynamicProxyTest {

    @Test
    public void test() {
        IService iService = new IServiceImpl();
        IService proxy = (IService) new JdkDynamicProxy().getProxy(iService);
        proxy.service();
    }

}
