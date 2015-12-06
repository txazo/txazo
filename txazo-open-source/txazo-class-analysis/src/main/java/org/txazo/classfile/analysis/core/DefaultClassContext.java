package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;
import org.txazo.classfile.analysis.util.ReflectionUtils;

import java.util.List;

public class DefaultClassContext implements ClassContext {

    private short constantPoolCount;

    private List<? extends ClassStruct> constantPools;

    private short interfacesCount;

    private short fieldsCount;

    @Override
    public short getConstantPoolCount() {
        return this.constantPoolCount;
    }

    @Override
    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    @Override
    public void setConstantPool(List<? extends ClassStruct> constantPools) {
        this.constantPools = constantPools;
    }

    @Override
    public ClassStruct getFromConstantPool(int index) {
        return constantPools.get(index - 1);
    }

    @Override
    public String getClassNameFromConstantPool(int index) throws Exception {
        ClassStruct classStruct = getFromConstantPool(index);
        short classNameIndex = ReflectionUtils.getFieldValue(classStruct, "name_index", short.class);
        ClassStruct classNameStruct = getFromConstantPool(classNameIndex);
        return ReflectionUtils.getFieldValue(classNameStruct, "bytes", String.class);
    }

    @Override
    public short getInterfacesCount() {
        return this.interfacesCount;
    }

    @Override
    public void setInterfacesCount(short interfacesCount) {
        this.interfacesCount = interfacesCount;
    }

    @Override
    public short getFieldsCount() {
        return this.fieldsCount;
    }

    @Override
    public void setFieldsCount(short fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

}
