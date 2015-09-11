package org.txazo.util.async;

/**
 * TaskConfig
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 2015-09-11
 */
public class TaskConfig {

    private String id;
    private int timeout;
    private Object defaultResult;

    public TaskConfig(String id, int timeout, Object defaultResult) {
        this.id = id;
        this.timeout = timeout;
        this.defaultResult = defaultResult;
    }

    public String getId() {
        return id;
    }

    public int getTimeout() {
        return timeout;
    }

    public Object getDefaultResult() {
        return defaultResult;
    }

}
