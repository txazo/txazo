package org.txazo.java.pattern.behavior.command.core;

/**
 * AbstractCommand
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public abstract class AbstractCommand implements Command {

    protected TV tv;

    public AbstractCommand(TV tv) {
        this.tv = tv;
    }

}
