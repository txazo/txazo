package org.txazo.wx.app.authority.annotation;

import org.txazo.wx.app.authority.AuthorityType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * AuthorityControl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AuthorityControl {

    AuthorityType type() default AuthorityType.ALL;

}
