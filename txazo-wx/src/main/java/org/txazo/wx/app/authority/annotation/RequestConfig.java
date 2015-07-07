package org.txazo.wx.app.authority.annotation;

import org.txazo.wx.app.common.enums.PrivilegeType;
import org.txazo.wx.app.common.enums.ClientType;
import org.txazo.wx.app.common.enums.HttpType;

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

    PrivilegeType authority() default PrivilegeType.ALL;

    ClientType[] client() default ClientType.ALL;

    HttpType http() default HttpType.ALL;

}
