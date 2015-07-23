package org.txazo.java.pattern.behavior.command.callback;

/**
 * Control
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Control {

    public void request(Command command) {
        command.execute();
    }

}
