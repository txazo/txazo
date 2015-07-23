package org.txazo.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * BeforeClass
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BeforeClass {

}
