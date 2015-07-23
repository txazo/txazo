package org.txazo.java.pattern.behavior.strategy.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * StrategyTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class StrategyTest {

    @Test
    public void test() {
        int a = 2, b = 3;
        Context context = new Context();
        context.setStrategy(new PlusStrategy());
        Assert.assertEquals(5, context.calculate(a, b));
        context.setStrategy(new MinusStrategy());
        Assert.assertEquals(-1, context.calculate(a, b));
        context.setStrategy(new MulStrategy());
        Assert.assertEquals(6, context.calculate(a, b));
    }

}
