package org.txazo.java.pattern.structural.facade.core;

import org.junit.Test;

/**
 * FacadeTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class FacadeTest {

    @Test
    public void test() {
        Facade facade = new Facade();
        facade.order();
        facade.facade();
    }

}
