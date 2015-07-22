package org.txazo.java.pattern.structural.decorator.core;

/**
 * Interceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public abstract class Interceptor implements Controller {

    private Controller controller;

    public Interceptor(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        interceptorBefore();
        controller.execute();
        interceptorAfter();
    }

    public abstract void interceptorBefore();

    public abstract void interceptorAfter();

}
