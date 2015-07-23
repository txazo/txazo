package org.txazo.util.lang;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * CloneUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public abstract class CloneUtils {

    public static <T> T clone(T t) {
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(t);
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
            IOUtils.closeQuietly(bais);
            IOUtils.closeQuietly(oos);
            IOUtils.closeQuietly(baos);
        }
        return null;
    }

}
