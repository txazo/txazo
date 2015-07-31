package org.txazo.java.core.enhancement.jdk4;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * AssertTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.07.2015
 */
public class AssertTest {

    /**
     * assert - 断言
     * <pre>
     * 1) assert expression;
     *    assert expression : message;
     * 2) expression为true, 继续执行
     *    expression为false, 抛出AssertionError, message为异常信息
     * </pre>
     */

    @Test
    public void test1() {
        int i = RandomUtils.nextInt(0, 2);
        assert i == 0;
    }

    @Test
    public void test2() {
        int i = RandomUtils.nextInt(0, 2);
        assert i == 0 : "i is not zero";
    }

}
