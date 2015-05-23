package org.txazo.util;

import org.junit.*;

public class ArrayUtilsTest {

    @Before
    public void before() {
        String str = null;
        //String a = str.toString();
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(ArrayUtils.isEmpty(null));
        Assert.assertTrue(ArrayUtils.isEmpty(new Object[0]));
        System.out.println(" 0 1");
    }

    @Test
    public void testIsNotEmpty() {
        Assert.assertTrue(ArrayUtils.isNotEmpty(new Object[]{1}));
        System.out.println(" 0 1");
    }

}
