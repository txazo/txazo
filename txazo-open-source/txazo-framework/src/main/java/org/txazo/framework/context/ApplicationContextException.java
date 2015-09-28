package org.txazo.framework.context;

import org.txazo.framework.bean.BeanException;

public class ApplicationContextException extends BeanException {

    public ApplicationContextException(String message) {
        super(message);
    }

    public ApplicationContextException(String message, Throwable cause) {
        super(message, cause);
    }

}
