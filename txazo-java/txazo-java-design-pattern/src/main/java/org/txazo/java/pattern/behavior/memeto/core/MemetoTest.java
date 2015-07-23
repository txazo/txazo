package org.txazo.java.pattern.behavior.memeto.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * MemetoTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class MemetoTest {

    @Test
    public void test() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("txazo");
        caretaker.saveMemento(originator.createMemento());
        Assert.assertEquals(originator.getState(), "txazo");

        originator.setState("admin");
        Assert.assertEquals(originator.getState(), "admin");

        originator.restoreMemento(caretaker.getMemento());
        Assert.assertEquals(originator.getState(), "txazo");
    }

}
