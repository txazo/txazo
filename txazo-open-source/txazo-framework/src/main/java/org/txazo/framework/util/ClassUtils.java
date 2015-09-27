package org.txazo.framework.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ClassUtils {

    private static Map<String, Class<?>> cacheClassMap = new ConcurrentHashMap<String, Class<?>>(64);

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;

        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable t) {
        }

        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
            if (classLoader == null) {
                try {
                    classLoader = ClassLoader.getSystemClassLoader();
                } catch (Throwable t) {
                }
            }
        }

        return classLoader;
    }

    public static Class<?> getClass(String className) throws ClassNotFoundException {
        if (cacheClassMap.containsKey(className)) {
            return cacheClassMap.get(className);
        }
        Class<?> clazz = Class.forName(className);
        cacheClassMap.put(className, clazz);
        return clazz;
    }

}
