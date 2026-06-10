package phucitdev.course.modules.classrooms.dto.teacher_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.modules.classrooms.entity.ClassroomStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherClassroomResponse {
    private UUID classroomId;
    private String name;
    private String code;
    private String description;
    private ClassroomStatus status;
    private Integer totalStudent;
    private LocalDate startDate;
    private LocalDate endDate;
}