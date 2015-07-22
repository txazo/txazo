package org.txazo.java.pattern.behavior.state.core;

import org.junit.Test;

/**
 * StateTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class StateTest {

    @Test
    public void test() {
        State onState = new OnState();
        State offState = new OffState();
        Context context = new Context(onState);
        context.request();
        context.changeState(offState);
        context.request();
    }

}
