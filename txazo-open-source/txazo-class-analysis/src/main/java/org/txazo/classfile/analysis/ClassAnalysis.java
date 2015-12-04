package org.txazo.classfile.analysis;

import org.txazo.classfile.analysis.core.ClassReader;
import org.txazo.classfile.analysis.core.MagicResolver;
import org.txazo.classfile.analysis.core.ResolverHandler;

public class ClassAnalysis {

    // 顺序流

    // 先解析魔数
    // 然后解析版本号
    // ...

    public void analysis(byte[] bytes) {
        ClassReader bufferWrapper = new ClassReader(bytes);

        ResolverHandler handler = new ResolverHandler();
        handler.addResolver(new MagicResolver());
        handler.doResolve(bufferWrapper);
    }

}
