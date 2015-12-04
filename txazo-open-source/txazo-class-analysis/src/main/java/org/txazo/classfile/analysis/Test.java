package org.txazo.classfile.analysis;

import java.io.Serializable;
import java.util.HashMap;

public class Test extends HashMap implements Serializable {

    private String a;

    public Test(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

}
