package org.txazo.reflection.type;

import org.apache.commons.lang3.ArrayUtils;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TypeUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 01.06.2015
 */
public class TypeUtils extends SuiteTest {

    public static String parseType(Type type) {
        StringBuffer out = new StringBuffer();
        parseType(type, out);
        return out.toString();
    }

    private static void parseType(Type type, StringBuffer out) {
        if (type instanceof GenericArrayType) {
            parseType(((GenericArrayType) type).getGenericComponentType(), out);
            out.append("[]");
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            out.append(((Class) pType.getRawType()).getSimpleName());
            Type[] types = pType.getActualTypeArguments();
            out.append("<");
            for (int i = 0; i < types.length; i++) {
                out.append(i > 0 ? ", " : "");
                parseType(types[i], out);
            }
            out.append(">");
        } else if (type instanceof TypeVariable) {
            TypeVariable vType = (TypeVariable) type;
            out.append(vType.getName());
            Type[] types = vType.getBounds();
            if (ArrayUtils.isNotEmpty(types) && !Arrays.asList(types).contains(Object.class)) {
                for (int i = 0; i < types.length; i++) {
                    out.append(i == 0 ? " extends " : " & ");
                    parseType(types[i], out);
                }
            }
        } else if (type instanceof WildcardType) {
            WildcardType wType = (WildcardType) type;

            Type[] bounds = null;
            if (ArrayUtils.isNotEmpty(bounds = wType.getLowerBounds())) {
                out.append("? super ");
            } else {
                bounds = wType.getUpperBounds();
                out.append("? extends ");
            }
            for (int i = 0; i < bounds.length; i++) {
                out.append(i > 0 ? " & " : "");
                parseType(bounds[i], out);
            }
        } else {
            out.append(((Class) type).getSimpleName());
        }

    }

    private abstract class AbstractClass<T, W, P> {

    }

    private abstract class MyClass<T> extends AbstractClass<T, List<? extends List>, Integer[]> {

        private Map<T, List<? super ArrayList>[]> map;

        public abstract List<Map<? extends List, T>>[] get();

        public abstract void set(List<List<Map<T, ? super ArrayList>>[]> list);

    }

    private interface MyInterface<T extends List & Serializable, K> {

    }

    @Test
    public void test1() throws Exception {
        assertEquals("AbstractClass<T, List<? extends List>, Integer[]>", parseType(TypeUtils.MyClass.class.getGenericSuperclass()));
        assertEquals("Map<T, List<? super ArrayList>[]>", parseType(TypeUtils.MyClass.class.getDeclaredField("map").getGenericType()));
        assertEquals("List<Map<? extends List, T>>[]", parseType(TypeUtils.MyClass.class.getMethod("get").getGenericReturnType()));
        assertEquals("List<List<Map<T, ? super ArrayList>>[]>", parseType(TypeUtils.MyClass.class.getMethod("set", List.class).getGenericParameterTypes()[0]));
        assertEquals("T extends List & Serializable", parseType(TypeUtils.MyInterface.class.getTypeParameters()[0]));
    }

}
