package org.txazo.test.suite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Suite
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 19.05.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Suite {

}
