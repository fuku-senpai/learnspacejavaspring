package phucitdev.course.modules.classrooms.dto.assign_teacher;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateTeacherClassroomRequest {
    @NotNull(message = "Teacher id không được để trống")
    private UUID teacherId;
}