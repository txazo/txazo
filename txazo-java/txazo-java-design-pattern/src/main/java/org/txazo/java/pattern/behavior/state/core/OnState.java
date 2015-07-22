package org.txazo.java.pattern.behavior.state.core;

/**
 * OnState
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class OnState implements State {

    @Override
    public void handle() {
        System.out.println("The state is on");
    }

}
