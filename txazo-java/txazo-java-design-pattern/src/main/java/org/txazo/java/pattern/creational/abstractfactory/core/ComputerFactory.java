package org.txazo.java.pattern.creational.abstractfactory.core;

/**
 * ComputerFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public interface ComputerFactory {

    public Cpu createCpu();

    public Mainboard createMainboard();

}
