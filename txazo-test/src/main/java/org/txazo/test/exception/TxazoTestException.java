package org.txazo.test.exception;

/**
 * TxazoTestException
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class TxazoTestException extends Exception {

    public TxazoTestException() {
    }

    public TxazoTestException(String message) {
        super(message);
    }

    public TxazoTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TxazoTestException(Throwable cause) {
        super(cause);
    }

    public TxazoTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
