package org.txazo.util;

import org.springframework.util.ConcurrentReferenceHashMap;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 反射工具类
 *
 * @author txazo
 * @email txazo1218@163.com
 * @qq 784990655
 * @since 05.05.2015
 */
public abstract class ReflectionUtils {

    private static final Map<Class<?>, Field[]> declaredFieldsCache = new ConcurrentReferenceHashMap<Class<?>, Field[]>(256);

    /**
     * 查找Field
     */
    public static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
    }

    /**
     * 查找Field
     */
    public static Field findField(Class<?> clazz, Class<?> type) {
        return findField(clazz, null, type);
    }

    /**
     * 查找Field
     */
    public static Field findField(Class<?> clazz, String name, Class<?> type) {
        if (clazz == null || (name == null && type == null)) {
            return null;
        }
        Class<?> searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = getDeclaredFields(searchType);
            for (Field field : fields) {
                if ((name == null || name.equals(field.getName())) && (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    private static Field[] getDeclaredFields(Class<?> clazz) {
        Field[] result = declaredFieldsCache.get(clazz);
        if (result == null) {
            result = clazz.getDeclaredFields();
            declaredFieldsCache.put(clazz, result);
        }
        return result;
    }

}
