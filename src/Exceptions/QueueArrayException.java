package Exceptions;

public class QueueArrayException  extends Exception {


    public static final String ERROR_CODE_MESSAGE = "Don´t exists a number for each character!";

    public static final String ERROR_STACK_IS_EMPTY = "This stack is empty";

    public QueueArrayException(final String MESSAGE) {
        super(MESSAGE);
    }
}