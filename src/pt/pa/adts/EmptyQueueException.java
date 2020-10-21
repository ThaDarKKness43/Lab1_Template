package pt.pa.adts;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException() { super("The queue is empty."); }
}
