package org.txazo.java.pattern.creational.abstractfactory.core;

/**
 * IntelComputerFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class IntelComputerFactory implements ComputerFactory {

    @Override
    public Cpu createCpu() {
        return new IntelCpu();
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard();
    }

}
