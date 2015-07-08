package org.txazo.reflection.util;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;

/**
 * ReflectionUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.05.2015
 */
public abstract class ReflectionUtils {

    /**
     * 是否get方法
     *
     * @param method
     * @return
     */
    public static boolean isGetter(Method method) {
        return (method.getName().startsWith("get")
                && ArrayUtils.isEmpty(method.getParameterTypes())
                && void.class != method.getReturnType())
                || isBooleanGetter(method);
    }

    /**
     * 是否boolean/Boolean的get方法
     *
     * @param method
     * @return
     */
    public static boolean isBooleanGetter(Method method) {
        return method.getName().startsWith("is")
                && ArrayUtils.isEmpty(method.getParameterTypes())
                && (boolean.class == method.getReturnType()
                || Boolean.class == method.getReturnType());
    }

}
