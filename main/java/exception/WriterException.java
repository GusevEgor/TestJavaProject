package exception;

public class WriterException extends RuntimeException {
    public WriterException(String message) {
        super("Error while writing: " + message);
    }
}
