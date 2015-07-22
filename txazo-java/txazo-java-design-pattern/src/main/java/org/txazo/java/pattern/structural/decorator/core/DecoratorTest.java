package org.txazo.java.pattern.structural.decorator.core;

import org.junit.Test;

/**
 * DecoratorTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class DecoratorTest {

    @Test
    public void test() {
        Controller controller = new IndexController();
        Interceptor loginInterceptor = new LoginInterceptor(controller);
        Interceptor logInterceptor = new LogInterceptor(loginInterceptor);
        logInterceptor.execute();
    }

}
