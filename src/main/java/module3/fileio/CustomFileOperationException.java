package module3.fileio;


public class CustomFileOperationException extends Exception {


    public CustomFileOperationException(String message) {
        super(message);
    }

    public CustomFileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}