package org.txazo.java.pattern.behavior.iterator.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * IteratorTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class IteratorTest {

    @Test
    public void test() {
        Tuple<String> tuple = new Tuple<String>();
        tuple.add("root");
        tuple.add("txazo");
        tuple.add("admin");
        tuple.add("manager");
        Iterator<String> iterator = tuple.iterator();
        Assert.assertEquals(iterator.first(), "root");
        Assert.assertEquals(iterator.last(), "manager");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }

}
