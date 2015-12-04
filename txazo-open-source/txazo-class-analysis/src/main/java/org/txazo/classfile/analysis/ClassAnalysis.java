package org.txazo.classfile.analysis;

import com.alibaba.fastjson.JSON;
import org.txazo.classfile.analysis.bean.ClassStruct;
import org.txazo.classfile.analysis.core.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassAnalysis {

    // 顺序流

    // 先解析魔数
    // 然后解析版本号
    // ...

    public void analysis(byte[] bytes) {
        ClassReader classReader = new ClassReader(bytes);

        ResolverHandler handler = new ResolverHandler();
        handler.addResolver(new MagicResolver());
        handler.addResolver(new MinorResolver());
        handler.addResolver(new MajorResolver());
        handler.addResolver(new ConstantPoolCountResolver());
        List<ClassStruct> classTree = handler.handleResolver(classReader);
        System.out.println(JSON.toJSONString(classTree));
    }

    public static void main(String[] args) throws IOException {
        ClassAnalysis analysis = new ClassAnalysis();
        InputStream input = ClassAnalysis.class.getResourceAsStream("/Test.class");
        byte[] temp = new byte[1028];
        int length = -1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((length = input.read(temp)) > 0) {
            baos.write(temp, 0, length);
        }
        analysis.analysis(baos.toByteArray());
    }

}
