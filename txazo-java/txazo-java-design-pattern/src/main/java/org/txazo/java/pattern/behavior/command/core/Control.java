package org.txazo.java.pattern.behavior.command.core;

/**
 * Control
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Control {

    private Command onCommand;
    private Command offCommand;
    private Command channelCommand;

    public Control(Command onCommand, Command offCommand, Command channelCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
        this.channelCommand = channelCommand;
    }

    public void turnOn() {
        onCommand.execute();
    }

    public void turnOff() {
        offCommand.execute();
    }

    public void changeChannel() {
        channelCommand.execute();
    }

}
