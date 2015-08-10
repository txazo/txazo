package org.txazo.blog.common.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RequestConfig
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequestConfig {

    HttpType http() default HttpType.UNLIMIT;

    PrivilegeType privilege() default PrivilegeType.UNLIMIT;

}
