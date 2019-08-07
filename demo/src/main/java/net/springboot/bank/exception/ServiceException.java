package net.springboot.bank.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = -7149081630131491814L;
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
