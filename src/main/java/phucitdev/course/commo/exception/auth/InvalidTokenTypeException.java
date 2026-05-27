package phucitdev.course.commo.exception.auth;

public class InvalidTokenTypeException extends RuntimeException {
    public InvalidTokenTypeException() {
        super("Invalid token type");
    }
}