package org.txazo.java.pattern.structural.decorator.core;

/**
 * LogInterceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class LogInterceptor extends Interceptor {

    public LogInterceptor(Controller controller) {
        super(controller);
    }

    @Override
    public void interceptorBefore() {
        System.out.println("LogInterceptor interceptorBefore");
    }

    @Override
    public void interceptorAfter() {
        System.out.println("LogInterceptor interceptorAfter");
    }

}
