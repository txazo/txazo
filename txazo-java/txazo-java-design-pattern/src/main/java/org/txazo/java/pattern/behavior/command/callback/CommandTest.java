package org.txazo.java.pattern.behavior.command.callback;

import org.junit.Test;

/**
 * CommandTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class CommandTest {

    @Test
    public void test() {
        final TV tv = new TV();
        Control control = new Control();
        control.request(new Command() {

            @Override
            public void execute() {
                tv.turnOn();
            }

        });
        control.request(new Command() {

            @Override
            public void execute() {
                tv.turnOff();
            }

        });
        control.request(new Command() {

            @Override
            public void execute() {
                tv.changeChannel();
            }

        });
    }

}
