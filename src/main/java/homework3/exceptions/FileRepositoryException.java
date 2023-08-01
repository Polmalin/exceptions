package homework3.exceptions;

public class FileRepositoryException extends RuntimeException {
    public FileRepositoryException(String message) {
        super(message);
    }

    public FileRepositoryException(Throwable throwable) {
        super(throwable);
    }
}
