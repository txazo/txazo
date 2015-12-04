package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;

public class MagicResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader) {
        return new Magic();
    }

    private static class Magic extends ClassStruct {

        private static final String magic = "0xCAFEBABE";

    }

}
