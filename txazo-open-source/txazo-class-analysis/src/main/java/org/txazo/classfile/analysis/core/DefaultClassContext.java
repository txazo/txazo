package org.txazo.classfile.analysis.core;

public class DefaultClassContext implements ClassContext {

    private int constantPoolCount;

    @Override
    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }

    @Override
    public void setConstantPoolCount(int constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

}
