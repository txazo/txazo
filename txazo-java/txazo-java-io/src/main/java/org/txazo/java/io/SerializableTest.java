package org.txazo.java.io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * SerializableTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.io.Serializable
 * @since 27.07.2015
 */
public class SerializableTest {

    /**
     * Serializable - 序列化
     * <pre>
     * 应用:
     * 1) 持久化存储(内存 文件 数据库)
     * 2) 网络传输(RPC Memcached Redis)
     * 3) 深度克隆
     * </pre>
     */

    @Test
    public void test() {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(new Entity(1, "", new Date()));
            ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            Entity entity = (Entity) ois.readObject();
        } catch (Exception e) {

        } finally {
            IOUtils.closeQuietly(oos);
        }
    }

    private class Entity implements Serializable {

        private int id;
        private String name;
        private transient Date createTime;

        public Entity(int id, String name, Date createTime) {
            this.id = id;
            this.name = name;
            this.createTime = createTime;
        }

    }

}
