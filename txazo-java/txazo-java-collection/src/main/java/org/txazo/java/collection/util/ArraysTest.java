package org.txazo.java.collection.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * ArraysTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.Arrays
 * @since 29.07.2015
 */
public class ArraysTest {

    @Test
    public void test() {
        /** 数组转List */
        List<String> users = Arrays.asList(new String[]{"root", "admin"});
    }

}
