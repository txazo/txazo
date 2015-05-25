package org.txazo.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Test {

    long timeout() default 0L;

    Class<? extends Throwable> expected() default Test.None.class;

    public static class None extends Throwable {

        private static final long serialVersionUID = 1L;

        private None() {
        }

    }

}
