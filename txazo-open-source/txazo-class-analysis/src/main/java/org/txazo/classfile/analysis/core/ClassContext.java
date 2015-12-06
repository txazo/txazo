package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

import java.util.List;

public interface ClassContext {

    public short getConstantPoolCount();

    public void setConstantPoolCount(short constantPoolCount);

    public void setConstantPool(List<? extends ClassStruct> constantPools);

    public ClassStruct getFromConstantPool(int index);

    public String getClassNameFromConstantPool(int index) throws Exception;

    public short getInterfacesCount();

    public void setInterfacesCount(short interfacesCount);

    public short getFieldsCount();

    public void setFieldsCount(short fieldsCount);

}
