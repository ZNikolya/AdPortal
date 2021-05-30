package homework.adPortal.exception;

public class TypeNotFoundException extends Exception {


    public TypeNotFoundException() {
    }

    public TypeNotFoundException(String message) {
        super(message);
    }

    public TypeNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public TypeNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}