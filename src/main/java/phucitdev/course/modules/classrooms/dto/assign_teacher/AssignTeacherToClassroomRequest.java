package phucitdev.course.modules.classrooms.dto.assign_teacher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignTeacherToClassroomRequest {
    @NotNull(message = "Teacher id không được để trống")
    private UUID teacherId;
}
