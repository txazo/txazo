package org.txazo.weixin.util;

import com.alibaba.fastjson.JSONArray;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * EnumUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public abstract class EnumUtils {

    /**
     * 枚举转JSON
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if (object.getClass().isEnum()) {
            Field[] fields = object.getClass().getDeclaredFields();
            try {
                for (Field field : fields) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    field.setAccessible(true);
                    jsonMap.put(field.getName(), field.get(object));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(jsonMap);
    }

}
