package org.txazo.java.pattern.creational.abstractfactory.core;

import org.junit.Test;

/**
 * AbstractFactoryTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class AbstractFactoryTest {

    @Test
    public void test() {
        ComputerBuilder.build(new AmdComputerFactory());
        ComputerBuilder.build(new IntelComputerFactory());
    }

}
