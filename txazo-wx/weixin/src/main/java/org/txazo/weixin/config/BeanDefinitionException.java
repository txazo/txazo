package org.txazo.weixin.config;

/**
 * BeanDefinitionException
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class BeanDefinitionException extends RuntimeException {

    public BeanDefinitionException() {
    }

    public BeanDefinitionException(String message) {
        super(message);
    }

    public BeanDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanDefinitionException(Throwable cause) {
        super(cause);
    }

    public BeanDefinitionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
