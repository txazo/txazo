package org.txazo.classfile.analysis.core;

public class DefaultClassContext implements ClassContext {

    private short constantPoolCount;

    @Override
    public short getConstantPoolCount() {
        return this.constantPoolCount;
    }

    @Override
    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

}
