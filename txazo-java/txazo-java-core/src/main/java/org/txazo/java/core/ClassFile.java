package org.txazo.java.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ClassFile implements Serializable {

    private static final long serialVersionUID = 2608745698314931228L;

    private static Map<String, String> map = new HashMap<String, String>();

    private int status = 0;
    private final String name;

    public ClassFile(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
