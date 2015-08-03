package org.txazo.java.jvm.sugar;

import org.junit.Test;

/**
 * InnerClassSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class InnerClassSugar {

    /**
     * 内部类 - 语法糖
     */

    @Test
    public InnerClass getLocalInnerClass() {
        /** 局部内部类 */
        class LocalInnerClass implements InnerClass {

        }

        return new LocalInnerClass();
    }

    @Test
    public InnerClass getAnonymousInnerClass() {
        /** 匿名内部类 */
        return new InnerClass() {

        };
    }

    public interface InnerClass {

    }

    /** 成员内部类 */
    class MemberInnerClass {

    }

    /** 静态内部类 */
    static class StaticInnerClass {

    }

}
