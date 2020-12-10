package by.AndreiKviatkouski.console.exception;

public class AddRoleException extends Exception {
    public AddRoleException() {
        super();
    }

    public AddRoleException(String message) {
        super(message);
    }

    public AddRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddRoleException(Throwable cause) {
        super(cause);
    }

    protected AddRoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
