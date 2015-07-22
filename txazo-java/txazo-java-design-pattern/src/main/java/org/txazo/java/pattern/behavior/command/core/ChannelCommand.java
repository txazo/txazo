package org.txazo.java.pattern.behavior.command.core;

/**
 * ChannelCommand
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ChannelCommand extends AbstractCommand {

    public ChannelCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }

}
