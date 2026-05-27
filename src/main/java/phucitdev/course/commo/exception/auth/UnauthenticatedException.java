package phucitdev.course.commo.exception.auth;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException() {
        super("Unauthenticated");
    }
}