package phucitdev.course.commo.exception.auth;

public class InvalidDeviceIdException extends RuntimeException {
    public InvalidDeviceIdException() {
        super("Invalid DeviceId");
    }
}
