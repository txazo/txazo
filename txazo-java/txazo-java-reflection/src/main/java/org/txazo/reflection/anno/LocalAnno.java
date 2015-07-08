package org.txazo.reflection.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LocalAnno
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.05.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.LOCAL_VARIABLE})
public @interface LocalAnno {

}
