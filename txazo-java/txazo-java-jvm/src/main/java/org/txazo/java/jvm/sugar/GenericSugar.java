package org.txazo.java.jvm.sugar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class GenericSugar {

    /**
     * 泛型 - 语法糖
     * <p>
     * 1) Java的泛型只在源代码中存在
     * 2) 编译后的class文件中已擦除泛型, 并插入强制转型的代码
     * 3) int method(List<Integer> list)和String method(List<String> list)不能重载
     */

    @Test
    public void test() {
        List<String> list = new ArrayList<String>();
        list.add("generic");
        String name = list.get(0);
    }

    @Test
    public void testDecompile() {
        List list = new ArrayList();
        list.add("generic");
        String name = (String) list.get(0);
    }

//    public int method(List<Integer> list) {
//        return -1;
//    }
//
//    public String method(List<String> list) {
//        return null;
//    }

}
