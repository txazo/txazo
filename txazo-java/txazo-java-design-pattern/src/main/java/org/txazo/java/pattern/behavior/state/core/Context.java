package org.txazo.java.pattern.behavior.state.core;

/**
 * Context
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }

    public void changeState(State state) {
        this.state = state;
    }

}
