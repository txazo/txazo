package org.txazo.java.pattern.behavior.visitor.core;

import org.junit.Test;

/**
 * VisitorTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class VisitorTest {

    @Test
    public void test() {
        ObjectSturcture objectSturcture = new ObjectSturcture();
        objectSturcture.attach(new ParkDestination());
        objectSturcture.attach(new MovieDestination());
        objectSturcture.display(new ChildVisitor());
        objectSturcture.display(new AdultVisitor());
    }

}
