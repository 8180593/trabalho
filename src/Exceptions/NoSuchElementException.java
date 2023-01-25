package Exceptions;

public class NoSuchElementException extends Throwable {
    public NoSuchElementException() {
    }

    public NoSuchElementException(String message) {
        super(message);
    }

    public NoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }
}