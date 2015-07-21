package org.txazo.java.pattern.creational.abstractfactory.core;

/**
 * AmdComputerFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class AmdComputerFactory implements ComputerFactory {

    @Override
    public Cpu createCpu() {
        return new AmdCpu();
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard();
    }

}
