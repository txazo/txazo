package org.txazo.java.pattern.behavior.command.core;

/**
 * OffCommand
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class OffCommand extends AbstractCommand {

    public OffCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        tv.turnOff();
    }

}
