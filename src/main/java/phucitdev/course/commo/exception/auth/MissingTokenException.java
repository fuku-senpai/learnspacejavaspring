package phucitdev.course.commo.exception.auth;

public class MissingTokenException extends RuntimeException {
    public MissingTokenException() {
        super("Token is missing");
    }
}