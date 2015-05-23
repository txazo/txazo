package org.txazo.util;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayUtilsTest1 {

    @BeforeClass
    public static void before() {
        String str = null;
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(ArrayUtils.isEmpty(null));
        Assert.assertTrue(ArrayUtils.isEmpty(new Object[0]));
        System.out.println(" 1 1");
    }

    @Test
    public void testIsNotEmpty() {
        Assert.assertTrue(ArrayUtils.isNotEmpty(new Object[]{1}));
        System.out.println(" 1 2");
    }

}
