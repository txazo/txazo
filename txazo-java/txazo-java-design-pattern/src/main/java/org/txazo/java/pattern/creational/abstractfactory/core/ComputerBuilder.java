package org.txazo.java.pattern.creational.abstractfactory.core;

/**
 * ComputerBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public abstract class ComputerBuilder {

    public static void build(ComputerFactory factory) {
        Cpu cpu = factory.createCpu();
        Mainboard mainboard = factory.createMainboard();
        System.out.println("Build computer with " + cpu.getName() + " and " + mainboard.getName());
    }

}
