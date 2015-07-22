package org.txazo.java.pattern.behavior.state.core;

/**
 * OffState
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class OffState implements State {

    @Override
    public void handle() {
        System.out.println("The state is off");
    }

}
