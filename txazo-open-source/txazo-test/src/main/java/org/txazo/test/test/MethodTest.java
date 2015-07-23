package org.txazo.test.test;

import org.txazo.test.annotation.Test;
import org.txazo.test.exception.TestException;
import org.txazo.test.annotation.After;
import org.txazo.test.annotation.Before;
import org.txazo.test.runner.TestExecuor;

import java.lang.reflect.Method;

/**
 * MethodTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class MethodTest extends AbstractTest {

    private Method method;

    public MethodTest(Method method) {
        this.method = method;
    }

    @Override
    public void test() {
        try {
            Test test = method.getAnnotation(Test.class);
            TestExecuor.executeAnnotationMethods(getClazz(), Before.class, false);
            TestExecuor.executeNoneStaticMethod(method, test.expected(), test.timeout());
            TestExecuor.executeAnnotationMethods(getClazz(), After.class, false);
            listener.addSuccess(this);
        } catch (TestException e) {
            listener.addError(this, getCauseThrowable(e));
        } catch (Throwable t) {
            listener.addError(this, t);
        }
    }

    public Class<?> getClazz() {
        return method.getDeclaringClass();
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return getClazz().getName() + "." + method.getName() + "()";
    }

}
