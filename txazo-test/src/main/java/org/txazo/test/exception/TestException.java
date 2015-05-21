package org.txazo.test.exception;

/**
 * TestException
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class TestException extends RuntimeException {

    public TestException() {
    }

    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestException(Throwable cause) {
        super(cause);
    }

    public TestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
