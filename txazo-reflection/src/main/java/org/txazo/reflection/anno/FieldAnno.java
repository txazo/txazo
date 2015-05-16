package org.txazo.reflection.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FieldAnno
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.05.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FieldAnno {

    String desc();

}
