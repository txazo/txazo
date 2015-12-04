package org.txazo.classfile.analysis.core;

import org.txazo.classfile.analysis.bean.ClassStruct;
import org.txazo.classfile.analysis.constant.Constant;

public class MagicResolver implements Resolver {

    @Override
    public ClassStruct resolve(ClassReader reader) {
        String magic = reader.readHex(4);
        if (!Constant.MAGIC.equalsIgnoreCase(magic)) {
            throw new RuntimeException("The file is not class format");
        }
        return new Magic(magic);
    }

    private static class Magic extends ClassStruct {

        private String magic;

        public Magic(String magic) {
            this.magic = magic;
        }

        public String getMagic() {
            return magic;
        }

    }

}
