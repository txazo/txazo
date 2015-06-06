package org.txazo.weixin.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EntityPath
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface EntityPath {

    String path();

}
