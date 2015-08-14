package org.txazo.blog.module.register.bean;

import java.io.Serializable;

/**
 * RegisterResult
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public class RegisterResult implements Serializable {

    private static final long serialVersionUID = -5143492689818771413L;

    private static final int FAIL = 0;
    private static final int SUCC = 1;

    public static final RegisterResult RESULT_SUCC = new RegisterResult(SUCC);

    private int status;
    private String message;

    private RegisterResult(int status) {
        this.status = status;
    }

    private RegisterResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean succ() {
        return status == SUCC;
    }

    public static RegisterResult fail(String message) {
        return new RegisterResult(FAIL, message);
    }

    public static RegisterResult succ(String message) {
        return new RegisterResult(SUCC, message);
    }

}
