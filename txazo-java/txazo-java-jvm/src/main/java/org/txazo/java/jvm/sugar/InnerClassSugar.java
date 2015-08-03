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
     * 内部类语法糖
     */

    @Test
    public InnerClass getLocalInnerClass() {
        class LocalInnerClass implements InnerClass {

        }

        return new LocalInnerClass();
    }

    @Test
    public InnerClass getAnonymousInnerClass() {
        return new InnerClass() {

        };
    }

    public interface InnerClass {

    }

    class MemberInnerClass {

    }

    static class StaticInnerClass {

    }

}
