package Exceptions;

public class ConcurrentModificationException extends Throwable {
    public ConcurrentModificationException() {
    }

    public ConcurrentModificationException(String message) {
        super(message);
    }
}