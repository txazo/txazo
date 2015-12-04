package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.buffer.ByteBufferWrapper;

import java.util.Map;

public interface Resolver {

    public Map<String, Object> resolve(ByteBufferWrapper bufferWrapper, Map<String, Object> treeMap);

}
