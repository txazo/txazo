package org.txazo.java.pattern.creational.builder.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * BuilderTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class BuilderTest {

    @Test
    public void test() {
        Builder builder = new ProductBuilder();
        Director director = new Director(builder);
        Product product = director.getProduct();
        Assert.assertEquals(product.getHead(), "head");
        Assert.assertEquals(product.getBody(), "body");
        Assert.assertEquals(product.getFoot(), "foot");
    }

}
