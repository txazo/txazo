package org.txazo.classfile.analysis.core;

public abstract class AbstractResolver implements Resolver {

    private Resolver next;

    public void setNext(Resolver next) {
        this.next = next;
    }

}
