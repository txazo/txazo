package org.txazo.java.pattern.behavior.chain.core;

import org.junit.Test;

/**
 * ChainTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ChainTest {

    @Test
    public void test() {
        Chain chain = new Chain();
        chain.addHandler(new LessHandler());
        chain.addHandler(new MiddleHandler());
        chain.addHandler(new MassHandler());
        chain.doHandle(10);
        chain.doHandle(1000);
        chain.doHandle(100000);
    }

}
