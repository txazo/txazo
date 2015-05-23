package org.txazo.test.simple.assertion;

/**
 * AssertionError
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.05.2015
 */
public class AssertionError extends Error {

    public AssertionError() {
        super();
    }

    public AssertionError(String message) {
        super(message);
    }

    public AssertionError(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionError(Throwable cause) {
        super(cause);
    }

    protected AssertionError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
