package org.txazo.java.pattern.structural.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JdkDynamicProxy - JDK动态代理
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class JdkDynamicProxy implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("Proxy before");
        result = method.invoke(target, args);
        System.out.println("Proxy after");
        return result;
    }

}
