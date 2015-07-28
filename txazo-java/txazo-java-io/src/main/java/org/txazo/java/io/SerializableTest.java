package org.txazo.java.io;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
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
public class SerializableTest implements Serializable {

    /**
     * Serializable - 序列化
     * <pre>
     * 应用:
     * 1) 持久化存储(内存 文件 数据库)
     * 2) 网络传输(RPC Memcached Redis)
     * 3) 深度克隆
     * </pre>
     */

    private static final long serialVersionUID = -2344012932604027089L;

    @Test
    public void test() {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(new Entity(1, "Serializable", new Date()));
            ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            Entity entity = (Entity) ois.readObject();
            Assert.assertEquals(1, entity.getId());
            Assert.assertEquals("Serializable", entity.getName());
            Assert.assertNull(entity.getCreateTime());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
            IOUtils.closeQuietly(oos);
            IOUtils.closeQuietly(baos);
        }
    }

    /**
     * <pre>
     * 1) 实现Serializable接口
     * 2) 生成serialVersionUID
     * 3) 反序列化时不会调用构造函数
     * </pre>
     */
    private class Entity implements Serializable {

        private static final long serialVersionUID = 4001675478954307558L;

        private int id;
        private String name;
        /** transient, 不参入系列化和反序列化 */
        private transient Date createTime;

        public Entity(int id, String name, Date createTime) {
            this.id = id;
            this.name = name;
            this.createTime = createTime;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }

}
