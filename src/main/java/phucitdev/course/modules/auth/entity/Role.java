package phucitdev.course.modules.auth.entity;

import phucitdev.course.commo.exception.auth.BadRequestException;

public enum Role {
    TEACHER,
    STUDENT,
    ADMIN;
    public static Role from(String value) {

        try {
            return Role.valueOf(
                    value.toUpperCase()
            );
        } catch (Exception e) {
            throw new BadRequestException(
                    "Role không hợp lệ"
            );
        }
    }
}
