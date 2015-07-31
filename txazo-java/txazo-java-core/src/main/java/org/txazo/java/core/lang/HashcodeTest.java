package org.txazo.java.core.lang;

/**
 * HashcodeTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.Object
 * @since 28.07.2015
 */
public class HashcodeTest {

    /**
     * Object.hashcode()
     *
     * 1) hashcode()用在HashMap HashSet Hashtable等散列表的数据结构中
     */

    /**
     * 未重写hashcode()
     */
    private class NotOverrideHashcode {

        protected int id;
        protected String name;

        public NotOverrideHashcode(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * 重写hashcode()
     */
    private class OverrideHashcode extends NotOverrideHashcode {

        public OverrideHashcode(int id, String name) {
            super(id, name);
        }

    }

}
