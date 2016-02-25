package org.txazo.tool.rpc.future2;

public enum TaskConfig {

    TASK_1("TASK_1", 150, false, ""),
    TASK_2("TASK_2", 100, true, Boolean.FALSE),
    TASK_3("TASK_3", 100, true, null);

    private String id;
    private int timeout;
    private boolean title;
    private Object defaultResult;

    TaskConfig(String id, int timeout, boolean title, Object defaultResult) {
        this.id = id;
        this.timeout = timeout;
        this.title = title;
        this.defaultResult = defaultResult;
    }

    public static TaskConfig getTaskConfig(String id) {
        for (TaskConfig config : values()) {
            if (config.getId().equals(id)) {
                return config;
            }
        }
        return null;
    }

    public static boolean isRequestTitle(String id) {
        TaskConfig config = getTaskConfig(id);
        return config != null && config.isTitle();
    }

    public String getId() {
        return id;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean isTitle() {
        return title;
    }

    public Object getDefaultResult() {
        return defaultResult;
    }

}
