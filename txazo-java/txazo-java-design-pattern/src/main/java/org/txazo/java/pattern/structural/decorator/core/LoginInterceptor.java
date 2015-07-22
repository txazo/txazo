package org.txazo.java.pattern.structural.decorator.core;

/**
 * LoginInterceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class LoginInterceptor extends Interceptor {

    public LoginInterceptor(Controller controller) {
        super(controller);
    }

    @Override
    public void interceptorBefore() {
        System.out.println("LoginInterceptor interceptorBefore");
    }

    @Override
    public void interceptorAfter() {
        System.out.println("LoginInterceptor interceptorAfter");
    }

}
