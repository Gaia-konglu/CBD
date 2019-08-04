package com.project.exception;

/**
 * Author: 周鑫
 * Date: 2018-10-15 17:18
 * Description: <描述>
 */
public class AccountExistException extends Exception{
    public AccountExistException() {
        super();
    }

    public AccountExistException(String message) {
        super(message);
    }

    public AccountExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountExistException(Throwable cause) {
        super(cause);
    }
}
