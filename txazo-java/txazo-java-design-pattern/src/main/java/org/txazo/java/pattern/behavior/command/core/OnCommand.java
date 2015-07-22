package org.txazo.java.pattern.behavior.command.core;

/**
 * OnCommand
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class OnCommand extends AbstractCommand {

    public OnCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

}
