package org.txazo.java.core.enhancement.jdk5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 增强for循环
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.07.2015
 */
public class ForTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }

}
