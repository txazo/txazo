package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public interface Resolver {

    public ClassStruct resolve(ClassReader reader, ClassContext context);

}
