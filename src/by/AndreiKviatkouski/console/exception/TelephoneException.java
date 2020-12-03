package by.AndreiKviatkouski.console.exception;

public class TelephoneException extends Exception{
    public TelephoneException() {
        super();
    }

    public TelephoneException(String message) {
        super(message);
    }

    public TelephoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelephoneException(Throwable cause) {
        super(cause);
    }

    protected TelephoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
