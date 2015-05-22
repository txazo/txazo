package org.txazo.util;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(ArrayUtils.isEmpty(null));
        Assert.assertTrue(ArrayUtils.isEmpty(new Object[0]));
    }

    @Test
    public void testIsNotEmpty() {
        Assert.assertTrue(ArrayUtils.isNotEmpty(new Object[]{1}));
    }

}
