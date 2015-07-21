package org.txazo.java.pattern.creational.prototype.cloneable;

import org.junit.Assert;
import org.junit.Test;

/**
 * PrototypeTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class PrototypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        Student student = new Student(1, "txazo", new Teacher(1, "txazo"));
        Student clone = student.clone();
        Assert.assertEquals(clone.getName(), "txazo");
        Assert.assertEquals(clone.getTeacher().getName(), "txazo");
    }

}
