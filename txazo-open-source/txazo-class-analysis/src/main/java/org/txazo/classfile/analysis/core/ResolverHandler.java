package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

import java.util.ArrayList;
import java.util.List;

public class ResolverHandler {

    private ClassContext context = new DefaultClassContext();
    private List<Resolver> resolves = new ArrayList<Resolver>();

    public void addResolver(Resolver resolver) {
        resolves.add(resolver);
    }

    public List<ClassStruct> handleResolver(ClassReader classReader) {
        List<ClassStruct> classStructs = new ArrayList<ClassStruct>();
        for (Resolver resolver : resolves) {
            classStructs.add(resolver.resolve(classReader, context));
        }
        return classStructs;
    }

}
