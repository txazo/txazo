package org.txazo.java.pattern.behavior.template.core;

/**
 * ConcreteTemplate
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ConcreteTemplate extends AbstractTemplate {

    @Override
    protected void abstractMethod() {
        System.out.println("ConcreteTemplate abstractMethod");
    }

}
