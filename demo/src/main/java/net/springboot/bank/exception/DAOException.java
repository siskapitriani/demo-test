package net.springboot.bank.exception;

public class DAOException extends Exception {
    private static final long serialVersionUID = 3879322386943684869L;
    public DAOException(String message) {
        super(message);
    }
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
