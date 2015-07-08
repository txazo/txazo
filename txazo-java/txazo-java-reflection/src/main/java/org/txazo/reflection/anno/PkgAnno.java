package org.txazo.reflection.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PkgAnno
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 24.05.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE})
public @interface PkgAnno {

}
