package org.txazo.classfile.analysis;

import com.alibaba.fastjson.JSON;
import org.txazo.classfile.analysis.bean.ClassStruct;
import org.txazo.classfile.analysis.core.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

public class ClassAnalysis {

    public void analysis(byte[] bytes) throws Exception {
        ClassReader reader = new ClassReader(bytes);

        ResolverHandler handler = new ResolverHandler();
        handler.addResolver(new MagicResolver());
        handler.addResolver(new MinorResolver());
        handler.addResolver(new MajorResolver());
        handler.addResolver(new ConstantPoolCountResolver());
        handler.addResolver(new ConstantPoolResolver());
        handler.addResolver(new AccessFlagsResolver());
        handler.addResolver(new ThisClassResolver());
        handler.addResolver(new SuperClassResolver());
        handler.addResolver(new InterfacesCountResolver());
        handler.addResolver(new InterfacesResolver());
        handler.addResolver(new FieldsCountResolver());
        List<ClassStruct> classTree = handler.handleResolver(reader);
        System.out.println(JSON.toJSONString(classTree));
    }

    public static void main(String[] args) throws Exception {
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
