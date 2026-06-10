package phucitdev.course.modules.classrooms.dto.classes_teachers;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClassroomWithTeacherResponse {
    private UUID classroomId;
    private String classroomName;
    private String code;
    private String description;
    private String status;
    private Integer totalStudent;
    private LocalDate startDate;
    private LocalDate endDate;
    private TeacherInfo teacher;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TeacherInfo {
        private UUID teacherId;
        private String fullName;
        private String email;
        private String avatar;
        private String specialization;
        private Integer yearsExperience;
    }
}
