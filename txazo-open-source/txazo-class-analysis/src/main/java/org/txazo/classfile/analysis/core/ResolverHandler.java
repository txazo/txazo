package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.buffer.ByteBufferWrapper;

public class ResolverHandler {

    private Resolver next;

    public void addResolver(AbstractResolver resolver) {
        resolver.setNext(next);
        next = resolver;
    }

    public void doResolve(ByteBufferWrapper bufferWrapper) {
        next.resolve(bufferWrapper);
    }

}
