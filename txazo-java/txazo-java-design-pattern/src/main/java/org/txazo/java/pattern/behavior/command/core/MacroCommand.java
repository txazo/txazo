package org.txazo.java.pattern.behavior.command.core;

/**
 * 组合命令
 */
public interface MacroCommand extends Command {

    public void addCommand(Command command);

    public void removeCommand(Command command);

}
