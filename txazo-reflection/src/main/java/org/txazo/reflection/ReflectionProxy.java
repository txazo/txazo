package org.txazo.reflection;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ReflectionProxy
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.InvocationHandler
 * @since 28.05.2015
 */
public class ReflectionProxy extends SuiteTest {

    /**
     * 1. 创建委托对象
     * 2. 创建代理对象并执行
     * 3. 执行InvocationHandler.invoke()
     * 4. method.invoke()执行委托对象的方法
     */
    class InvocationHandlerProxy implements InvocationHandler {

        private Object target;

        /** 传入委托对象 */
        public <T> T getProxy(T target) {
            this.target = target;
            /** 生成代理对象并返回 */
            return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        /**
         * 代理实现
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            println("println before");
            /** 执行委托对象的方法 */
            result = method.invoke(target, args);
            println("println after");
            return result;
        }

    }

    interface MyInterface {

        public void execute();

    }

    class MyClass implements MyInterface {

        @Override
        public void execute() {
            println("execute");
        }

    }

    @Test
    public void test1() {
        InvocationHandlerProxy handler = new InvocationHandlerProxy();
        /** 创建代理类 */
        MyInterface proxy = handler.getProxy(new MyClass());
        proxy.execute();
    }

}
