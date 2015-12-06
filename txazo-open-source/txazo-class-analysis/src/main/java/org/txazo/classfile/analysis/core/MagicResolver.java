package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;
import org.txazo.classfile.analysis.constant.Constant;

public class MagicResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader, ClassContext context) {
        String magic = reader.readHex(4);
        if (!Constant.MAGIC.equalsIgnoreCase(magic)) {
            throw new RuntimeException("This file is not class format");
        }
        return new Magic();
    }

    private static class Magic extends ClassStruct {

        private String magic = Constant.MAGIC;

        public String getMagic() {
            return magic;
        }

    }

}
