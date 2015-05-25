package org.txazo.test.util;

import org.txazo.test.exception.TestException;
import org.txazo.test.filter.ClassFileFilter;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * PackageUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public abstract class PackageUtils {

    private static boolean existsAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
        return clazz != null && clazz.getAnnotation(annotation) != null;
    }

    public static Set<Class<?>> getClassesWithAnnotation(String packageName, Class<? extends Annotation> annotation) {
        return getClassesWithAnnotation(packageName, annotation, null, true);
    }

    public static Set<Class<?>> getClassesWithAnnotation(String packageName, Class<? extends Annotation> annotation, Class<?> excludeClass, boolean recursive) {
        AssertUtils.assertNotNull(annotation);
        AssertUtils.assertNotBlank(packageName);
        Class<?> superClass = null;
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        for (Class<?> clazz : getClasses(packageName, recursive)) {
            superClass = clazz;
            if (superClass == excludeClass) {
                continue;
            }
            while (superClass != Object.class) {
                if (superClass == null || superClass.isInterface() || superClass.isAnnotation()) {
                    break;
                }
                if (existsAnnotation(superClass, annotation)) {
                    classes.add(clazz);
                    break;
                }
                superClass = superClass.getSuperclass();
            }
        }
        return classes;
    }

    public static Set<Class<?>> getClasses(String packageName) {
        return getClasses(packageName, true);
    }

    public static Set<Class<?>> getClasses(String packageName, boolean recursive) {
        AssertUtils.assertNotBlank(packageName);
        String packageDir = packageName.replace(".", "/");
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();

        URL url = null;
        String filePath = null;
        try {
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDir);
            while (dirs.hasMoreElements()) {
                url = dirs.nextElement();
                if ("file".equals(url.getProtocol())) {
                    filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                }
            }
        } catch (IOException e) {
            throw new TestException(e);
        }

        return classes;
    }

    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, boolean recursive, Set<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] files = dir.listFiles(new ClassFileFilter(recursive));
        if (ArrayUtils.isEmpty(files)) {
            return;
        }

        try {
            String className = null;
            for (File file : files) {
                if (file.isDirectory()) {
                    findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
                } else {
                    className = file.getName().substring(0, file.getName().length() - 6);
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                }
            }
        } catch (ClassNotFoundException e) {
            throw new TestException(e);
        }
    }

}
